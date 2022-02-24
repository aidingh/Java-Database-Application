package com.example.javadatabaseproject.repositories;

import com.example.javadatabaseproject.access.layer.CustomerDao;
import com.example.javadatabaseproject.models.*;
import com.example.javadatabaseproject.mappers.CountryMapper;
import com.example.javadatabaseproject.mappers.HighestSpenderMapper;
import com.example.javadatabaseproject.mappers.PopularGenreMapper;
import com.example.javadatabaseproject.mappers.CustomerMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author Aidin Ghassemloi och Richard Cruz.
 * Repository class implmenets customer data access object.
 * Class is responseble for handeling querys and map the results back to the controller class.
 * Function executes the local query defined in the function and RowMaps its results with a custom mapper.
 */

@Repository
public class CustomerRepository implements CustomerDao {

    public final String attributes =  "CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email";
    public JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Function returns all customers in an alphabetic order.
     * Custom mapper : CustomerMapper
     *
     * @return List<Customer>
     */
    @Override
    public List<Customer> getAllCustomers() {
        String query = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer ORDER BY FirstName";
        return this.jdbcTemplate.query(query, new CustomerMapper());
    }

    /**
     * Function returns a customer by id.
     * Custom mapper : CustomerMapper
     *
     * @return Customer
     * @param id id defined by client.
     */
    @Override
    public Customer getCustomerById(String id) {
        String query = "SELECT " + attributes + " FROM customer WHERE CustomerId" + "=" + id;
        return this.jdbcTemplate.queryForObject(query, new CustomerMapper());
    }

    /**
     * Function returns a customer by name.
     * Custom mapper : CustomerMapper
     *
     * @return Customer
     * @param name id defined by client.
     */
    @Override
    public Customer getCustomerByName(String name) {
        String query = "SELECT " + attributes + " FROM customer " +
                "WHERE FirstName LIKE " +"'%" + name + "%'";
        return this.jdbcTemplate.queryForObject(query, new CustomerMapper());
    }

    /**
     * Function returns a subset of all customers.
     * Custom mapper : CustomerMapper
     *
     * @param limit limit integer value defined by client.
     * @param offset offset integer value defined by client.
     * @return List<Customer>
     */
    @Override
    public List<Customer> getSubsetOfCustomers(String limit, String offset) {

        StringBuilder queryBuilder = new StringBuilder();
        String query = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer ";
        queryBuilder.append(query);
        if(Integer.parseInt(limit) > 0) {
            queryBuilder.append("LIMIT ");
            if(Integer.parseInt(offset) > 0) {
                queryBuilder.append(offset);
                queryBuilder.append(", ");
            }
            queryBuilder.append(limit);
            queryBuilder.append(" ");
        }
        return this.jdbcTemplate.query(queryBuilder.toString(), new CustomerMapper());
    }

    /**
     * Function will insert a new customer and return the inserted customer by id.
     * Custom mapper : CustomerMapper
     *
     * @param customer Customer object defined as a JSON-body.
     * @return Customer
     */
    @Override
    public Customer insertCustomer(Customer customer) {
       String query = "INSERT INTO customer(CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email) VALUES (?,?,?,?,?,?,?)";
       this.jdbcTemplate.update(query, customer.customerId, customer.firstName,customer.lastName,customer.country, customer.postalCode,customer.phone,customer.email);
       return this.getCustomerById(String.valueOf(customer.customerId));
    }

    /**
     * Function will update a new customer and return the inserted customer by id.
     * Custom mapper : CustomerMapper
     *
     * @param customer Customer object defined as a JSON-body.
     * @return Customer
     */
    @Override
    public Customer updateCustomer(Customer customer) {
        String query = "UPDATE customer " +
                       "SET FirstName=?, LastName=?, Country=?, PostalCode=?, Phone=?, Email=? " +
                       "WHERE CustomerId = ?";

       this.jdbcTemplate.update(query, customer.firstName,customer.lastName,customer.country, customer.postalCode,customer.phone,customer.email, customer.customerId);
       return this.getCustomerById(String.valueOf(customer.customerId));
    }

    /**
     * Function will return number of customers in each country in descending order.
     * Custom mapper : CountryMapper
     *
     * @return List<CustomerCountry>
     */
    @Override
    public List<CustomerCountry> getCustomerByCountry() {
        String query = "SELECT Country, COUNT(*) AS NumberOfCountries " +
                       "FROM Customer " +
                       "GROUP BY Country " +
                       "ORDER BY NumberOfCountries DESC;";
        return this.jdbcTemplate.query(query, new CountryMapper());
    }

    /**
     * Function will return the highest spending customers.
     * Custom mapper : HighestSpenderMapper
     *
     * @return List<CustomerSpender>
     */
    @Override
    public List<CustomerSpender> getHighestSpender() {
        String query = "SELECT FirstName, LastName, SUM(Invoice.Total) AS HighestSpender " +
                       "FROM  Customer " +
                       "INNER JOIN Invoice ON Customer.CustomerId = Invoice.InvoiceId " +
                       "GROUP BY Customer.CustomerId " +
                       "ORDER BY HighestSpender DESC;";
        return this.jdbcTemplate.query(query, new HighestSpenderMapper());
    }

    /**
     * Function will return the most popular music a customer can have.
     * Custom mapper : PopularGenreMapper
     *
     * @return List<CustomerGenre>
     */
    @Override
    public List<CustomerGenre> getPopularGenre(int id) {
        String query = "WITH POPULAR_CUSTOMER AS ( " +
                             "SELECT C.FirstName, C.LastName, g.Name, COUNT(T.TrackId) AS QUANTITY " +
                             "FROM Customer C " +
                                    "INNER JOIN Invoice I on C.CustomerId = I.CustomerId " +
                                    "INNER JOIN InvoiceLine IL on I.InvoiceId = IL.InvoiceId " +
                                    "INNER JOIN Track T on IL.TrackId = T.TrackId " +
                                    "INNER JOIN Genre G on T.GenreId = G.GenreId " +
                             "WHERE C.CustomerId = ? " +
                             "GROUP BY G.GenreId " +
                                ") " +
                             "SELECT POPULAR_CUSTOMER.* " +
                             "FROM POPULAR_CUSTOMER " +
                             "WHERE POPULAR_CUSTOMER.QUANTITY = (SELECT max(POPULAR_CUSTOMER.QUANTITY) FROM POPULAR_CUSTOMER);";

        return this.jdbcTemplate.query(query, new PopularGenreMapper(),id);
    }
}
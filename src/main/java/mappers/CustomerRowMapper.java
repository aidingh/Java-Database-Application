package mappers;

import com.example.javadatabaseproject.models.Customer;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new Customer(
                            rs.getInt("customerId"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("country"),
                            rs.getString("postalCode"),
                            rs.getString("phone"),
                            rs.getString("email")
                    );
    }
}

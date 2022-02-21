package com.example.javadatabaseproject.connection.managers;
import java.sql.*;

public class ConnectionManager {

    public String URL = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    public Connection driverConnection;
    public ResultSet set;
    public PreparedStatement prepStatement;
    public ConnectionManager() {

    }

    public void connectManager(){
        try{
            this.driverConnection = DriverManager.getConnection(this.URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnectManager(){
        try{
            driverConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSqlQuery(String QUERY) throws SQLException {
        this.set = this.driverConnection.createStatement().executeQuery(QUERY);
    }
    public void runUpdateSqlCommand(String QUERY) throws  SQLException {
        this.prepStatement = this.driverConnection.prepareStatement(QUERY);

    }

    public void prepareSqlQuery(String QUERY) throws SQLException {
        this.set = this.driverConnection.prepareStatement(QUERY).executeQuery();
    }

    public void printTable() throws SQLException {
        while (this.set.next()) {
            for (int i = 1; i <= this.set.getMetaData().getColumnCount(); i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = this.set.getString(i);
                System.out.print(columnValue + " " + this.set.getMetaData().getColumnName(i));
            }
            System.out.println("");
        }
    }
}

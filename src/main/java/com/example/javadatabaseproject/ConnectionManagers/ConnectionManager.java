package com.example.javadatabaseproject.ConnectionManagers;
import java.sql.*;

public class ConnectionManager {

    public String URL = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    public Connection driverConnection;
    public ResultSet set;

    public ConnectionManager() {

    }

    public void connectManager(){
        try{
            this.driverConnection = DriverManager.getConnection(this.URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void runSqlCommand(String QUERY) throws SQLException {
        this.set = this.driverConnection.createStatement().executeQuery(QUERY);
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

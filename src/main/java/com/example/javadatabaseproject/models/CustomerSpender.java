package com.example.javadatabaseproject.models;

public class CustomerSpender {

    private String firstName;
    private String lastName;
    private String totalSpent;

    public CustomerSpender(String firstName, String lastName, String totalSpent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalSpent = totalSpent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(String totalSpent) {
        this.totalSpent = totalSpent;
    }
}

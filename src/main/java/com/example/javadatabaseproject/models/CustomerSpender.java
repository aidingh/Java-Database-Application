package com.example.javadatabaseproject.models;

public class CustomerSpender {

    private int id;
    private String firstName;
    private String lastName;
    private int totalSpent;

    public CustomerSpender(int id, String firstName, String lastName, int totalSpent) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalSpent = totalSpent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(int totalSpent) {
        this.totalSpent = totalSpent;
    }
}

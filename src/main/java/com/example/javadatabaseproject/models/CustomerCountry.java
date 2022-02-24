package com.example.javadatabaseproject.models;

/**
 * @author Aidin Ghassemloi och Richard Cruz.
 * CustomerCountry model and its attributes.
 */
public class CustomerCountry {

 private String country;
 private int quantity;

    public CustomerCountry(String country, int quantity) {
        this.country = country;
        this.quantity = quantity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

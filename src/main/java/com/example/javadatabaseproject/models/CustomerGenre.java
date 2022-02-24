package com.example.javadatabaseproject.models;

/**
 * @author Aidin Ghassemloi och Richard Cruz.
 * CustomerGenre model and its attributes.
 */
public class CustomerGenre {

 private String firstName;
 private String lastName;
 private String genreName;
 private String quantity;

    public CustomerGenre(String firstName, String lastName, String genreName, String quantity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.genreName = genreName;
        this.quantity = quantity;
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

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

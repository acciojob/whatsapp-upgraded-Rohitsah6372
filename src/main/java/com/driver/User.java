package com.driver;

public class User {
    private int id;           // Add this field
    private String name;
    private String mobile;

    public User() {
        // Default constructor
    }

    public User(int id, String name, String mobile) {
        this.id = id;         // Initialize id
        this.name = name;
        this.mobile = mobile;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +          // Include id in toString
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}

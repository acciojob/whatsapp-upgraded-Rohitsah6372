package com.driver;

import java.util.*;

public class Group {
    private int id;           // Add this field
    private List<User> users;
    private String name;

    public Group() {
        // Default constructor
    }

    public Group(int id, List<User> users, String name) {
        this.id = id;         // Initialize id
        this.users = users;
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

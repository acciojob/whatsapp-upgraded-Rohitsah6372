package com.driver;

import java.util.*;

public class Group {
    private List<User> users;
    private String name;

    public Group(List<User> users, String name) {
        this.users = users;
        this.name = name;
    }

    // Getters and Setters
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

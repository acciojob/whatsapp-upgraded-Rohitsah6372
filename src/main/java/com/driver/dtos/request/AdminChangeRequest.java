package com.driver.dtos.request;

import com.driver.Group;
import com.driver.User;

public class AdminChangeRequest {
    private User approver;
    private User newAdmin;
    private Group group;

    public AdminChangeRequest() {
        // Default constructor
    }

    public AdminChangeRequest(User approver, User newAdmin, Group group) {
        this.approver = approver;
        this.newAdmin = newAdmin;
        this.group = group;
    }

    // Getters and Setters
    public User getApprover() {
        return approver;
    }

    public void setApprover(User approver) {
        this.approver = approver;
    }

    public User getNewAdmin() {
        return newAdmin;
    }

    public void setNewAdmin(User newAdmin) {
        this.newAdmin = newAdmin;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getUser() {
        return newAdmin;
    }
}

package com.driver.dtos.request;

import com.driver.Group;
import com.driver.Message;
import com.driver.User;

public class MessageRequest {
    private String content;
    private User sender;
    private Group group;

    public MessageRequest() {
        // Default constructor
    }

    public MessageRequest(String content, User sender, Group group) {
        this.content = content;
        this.sender = sender;
        this.group = group;
    }

    // Getters and Setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    // Method to convert MessageRequest to Message
    public Message getMessage() {
        int id = 0;
        if (sender != null) {
            id = sender.getId();
        } else if (group != null) {
            id = group.getId();
        }
        return new Message(id, content);
    }
}

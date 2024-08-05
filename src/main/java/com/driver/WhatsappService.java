package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WhatsappService {

    WhatsappRepository whatsappRepository = new WhatsappRepository();

    public String createUser(String name, String mobile) throws Exception {
        User user = new User(name, mobile);

        if (whatsappRepository.userExists(user)) {
            throw new Exception("User already exists");
        }
        return whatsappRepository.createUser(name, mobile);
    }

    public Group createGroup(List<User> users) throws Exception {
        // The list contains at least 2 users where the first user is the admin.
        // If there are only 2 users, the group is a personal chat and the group name should be kept as the name of the second user(other than admin)
        // If there are 2+ users, the name of group should be "Group #count". For example, the name of first group would be "Group 1", second would be "Group 2" and so on.
        // Note that a personal chat is not considered a group and the count is not updated for personal chats.

        if (users.size() < 2) {
            throw new Exception("At least 2 users are required to create a group");
        }

        // Determine the group name
        String groupName;
        if (users.size() == 2) {
            groupName = users.get(1).getName(); // Personal chat
        } else {
            int groupCount = whatsappRepository.getGroupCount();
            groupName = "Group " + (groupCount + 1);
        }

        return whatsappRepository.createGroup(users);
    }

    public int createMessage(String content){
        // The 'i^th' created message has message id 'i'.
        return whatsappRepository.createMessage(content);
    }

    public int sendMessage(Message message, User sender, Group group) throws Exception{
        //Throw "Group does not exist" if the mentioned group does not exist
        //Throw "You are not allowed to send message" if the sender is not a member of the group
        if (!whatsappRepository.groupExists(group)) {
            throw new Exception("Group does not exist");
        }

        // Check if sender is a member of the group
        if (!whatsappRepository.isMember(sender, group)) {
            throw new Exception("You are not allowed to send message");
        }


        return  whatsappRepository.sendMessage(message, sender, group);
    }

    public String changeAdmin(User approver, User user, Group group) throws Exception{
        //Change the admin of the group to "user".
        //Throw "Group does not exist" if the mentioned group does not exist
        //Throw "Approver does not have rights" if the approver is not the current admin of the group
        //Throw "User is not a participant" if the user is not a part of the group
        if (!whatsappRepository.groupExists(group)) {
            throw new Exception("Group does not exist");
        }

        // Check if approver is the current admin
        if (!whatsappRepository.isAdmin(approver, group)) {
            throw new Exception("Approver does not have rights");
        }

        // Check if user is a participant
        if (!whatsappRepository.isParticipant(user, group)) {
            throw new Exception("User is not a participant");
        }



        return whatsappRepository.changeAdmin(approver, user, group);
    }

    public int removeUser(User user) throws Exception{
        //If user is not found in any group, throw "User not found" exception
        //If user is found in a group and it is the admin, throw "Cannot remove admin" exception
        //If user is not the admin, remove the user from the group, remove all its messages from all the databases, and update relevant attributes accordingly.
        if (!whatsappRepository.userExists(user)) {
            throw new Exception("User not found");
        }

        Group userGroup = whatsappRepository.getUserGroup(user);
        if (whatsappRepository.isAdmin(user, userGroup)) {
            throw new Exception("Cannot remove admin");
        }



        return whatsappRepository.removeUser(user);
    }

    public String findMessage(Date start, Date end, int K) throws Exception{
        // Find the Kth latest message between start and end (excluding start and end)
        // If the number of messages between given time is less than K, throw "K is greater than the number of messages" exception
        List<Message> messages = whatsappRepository.findMessages(start, end);
        if (messages.size() < K) {
            throw new Exception("K is greater than the number of messages");
        }


        messages.sort(Comparator.comparing(Message::getDate).reversed());
        return messages.get(K - 1).getContent();
    }
}
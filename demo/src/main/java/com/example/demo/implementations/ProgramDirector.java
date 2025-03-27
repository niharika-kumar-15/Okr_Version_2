package com.example.demo.implementations;

import com.example.demo.interfaces.UserComponent;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProgramDirector implements UserComponent {
    @Autowired
    private User user;
    @Autowired
    private List<UserComponent> subordinates = new ArrayList<>();

    // Constructor
    public ProgramDirector(User user) {
        this.user = user;
    }

    @Override
    public void addUser(UserComponent c) {
        subordinates.add(c);
    }

    @Override
    public void removeUser(UserComponent c) {
        subordinates.remove(c);
    }

    @Override
    public void display() {
        System.out.println(this.toString()); // Display manager's information
        for (UserComponent subordinate : subordinates) {
            subordinate.display();  // Recursively display subordinates
        }
    }

    @Override
    public String toString() {
        return "Program Director [Name: " + user.getUsername() + ", Role: " + user.getDesignation() + "]";
    }
}

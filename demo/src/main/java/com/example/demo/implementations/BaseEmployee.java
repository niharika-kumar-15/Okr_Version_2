package com.example.demo.implementations;

import com.example.demo.interfaces.UserComponent;
import com.example.demo.model.User;  // Assuming User is your domain class for users
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseEmployee implements UserComponent {
    @Autowired
    private User user;

    // Constructor
    public BaseEmployee(User user) {
        this.user = user;
    }

    @Override
    public void addUser(UserComponent c) {
        throw new UnsupportedOperationException("Cannot add user to a base employee.");
    }

    @Override
    public void removeUser(UserComponent c) {
        throw new UnsupportedOperationException("Cannot remove user from a base employee.");
    }

    @Override
    public void display() {
        System.out.println(this.toString());  // Display base employee's information
    }

    @Override
    public String toString() {
        return "Base Employee [Name: " + user.getUsername() + ", Role: " + user.getDesignation() + "]";
    }
}

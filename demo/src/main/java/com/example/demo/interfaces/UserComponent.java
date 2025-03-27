package com.example.demo.interfaces;


// this is the  parent of all Components
public  interface UserComponent {
    void addUser(UserComponent c);
    void removeUser(UserComponent c);
    void display();
}


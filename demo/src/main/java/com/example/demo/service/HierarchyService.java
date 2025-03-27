package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enums.Role;
import com.example.demo.implementations.BaseEmployee;
import com.example.demo.implementations.ProgramDirector;
import com.example.demo.interfaces.UserComponent;
import java.util.List;


//This service is going to handle the hierarchy. It will basically retrieve
//the hierarchy from the db and store in some object and return the object.


@Service
public class HierarchyService {

    @Autowired
    private UserRepository userRepository;

    public UserComponent getUserHierarchy(String username) {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            return null;
        }
        if(user.getRole().equalsIgnoreCase("BaseEmployee")){
            return new BaseEmployee(user);
        }
        return buildHierarchy(user);
    }

    private UserComponent buildHierarchy(User user) {
       UserComponent hierarachy = new ProgramDirector(user);
       List<User> subordinates = userRepository.findUsersByManagerId(user.getUserId());
       for(User subordinate : subordinates){
            if(subordinate.getRole().equalsIgnoreCase("ProgramDirector")){
                //UserComponent uc = new ProgramDirector(subordinate);
                UserComponent uc = buildHierarchy(subordinate);
                hierarachy.addUser(uc);
            }

       }


        return hierarachy ;
    }
}



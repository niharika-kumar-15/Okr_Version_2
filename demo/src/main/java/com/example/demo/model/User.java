package com.example.demo.model;

import com.example.demo.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "group_id")
    private Long groupId;

    // Many-to-Many relationship with Objective
    @ManyToMany
    @JoinTable(
            name = "user_objective",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "objective_id")
    )
    @JsonIgnore
    private List<Objective> objectives;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "designation")
    private String designation;


    @Column(name = "role")
    private String role;

    @Column(name = "email")
    private String email;

    public User() {
    }

    // Modify the constructor to accept String and convert it to Role
    public User(String username, String designation , long managerId , String email ) {
        this.username = username;
        this.managerId = managerId;
        this.designation = designation;
        this.email = email;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", groupId=" + groupId +
                ", managerId=" + managerId +
                ", designation='" + designation + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                '}';
    }
}

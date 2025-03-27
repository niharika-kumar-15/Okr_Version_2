package com.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId; // Primary key for the group

    @Column(name = "group_name", nullable = false)
    private String groupName; // Name of the group

    @Column(name = "objective_id")
    private Long objectiveId;
}

package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "objectives")
public class Objective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "objective_id")
    private Long objectiveId;

    @Column(name = "user_id", nullable = true)
    private Long userId;


    @Column(name = "objective_name", nullable = false)
    private String objectiveName;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "objective", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Task> tasks;

    public Objective() {}

    public Objective(Long userId,String objectiveName, String description) {
        this.userId = userId;
        this.objectiveName = objectiveName;
        this.description = description;
    }

    public Long getObjectiveId() {
        return objectiveId;
    }

    public String getObjectiveName() {
        return objectiveName;
    }

    public void setObjectiveName(String objectiveName) {
        this.objectiveName = objectiveName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

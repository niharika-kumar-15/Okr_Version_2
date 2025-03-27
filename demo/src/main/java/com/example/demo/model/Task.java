package com.example.demo.model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @ManyToOne
    @JoinColumn(name = "objective_id", nullable = false)
    private Objective objective;

    @Column(name = "description")
    private String description;

    @Column(name = "task_objective", nullable = false)
    private String taskObjective;

    @Column(name = "can_be_divided", nullable = false)
    private Boolean canBeDivided;

    @ManyToOne
    @JoinColumn(name = "parent_task_id")
    private Task parentTask;

    @OneToMany(mappedBy = "parentTask", cascade = CascadeType.ALL)
    private List<Task> subTasks;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "due_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;

    @Column(name = "progress", nullable = false)
    private Integer progress = 0;

    public Task() {}

    public Task(String taskName, Objective objective, String description, Boolean canBeDivided, Task parentTask, Long userId, Date dueDate) {
        if (objective == null) {
            throw new IllegalArgumentException("Objective cannot be null");
        }
        this.taskName = taskName;
        this.objective = objective;
        this.description = description;
        this.canBeDivided = canBeDivided;
        this.parentTask = parentTask;
        this.userId = userId;
        this.dueDate = dueDate;
        this.taskObjective = objective.getObjectiveName();  // ✅ Ensure `task_objective` is set properly
        this.progress = 0;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
        this.taskObjective = (objective != null) ? objective.getObjectiveName() : null;  // ✅ Set taskObjective dynamically
    }
    public void setTaskObjective(String taskObjective) {
        this.taskObjective = taskObjective;
    }


    public String getTaskObjective() {
        return taskObjective;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCanBeDivided() {
        return canBeDivided;
    }

    public void setCanBeDivided(Boolean canBeDivided) {
        this.canBeDivided = canBeDivided;
    }

    public Task getParentTask() {
        return parentTask;
    }

    public void setParentTask(Task parentTask) {
        this.parentTask = parentTask;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<Task> subTasks) {
        this.subTasks = subTasks;
    }
}

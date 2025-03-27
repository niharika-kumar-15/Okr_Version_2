package com.example.demo.service;

import com.example.demo.model.Objective;
import com.example.demo.model.Task;
import com.example.demo.repository.ObjectiveRepository;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ObjectiveRepository objectiveRepository;

    public Task createTask(Task task) {
        // Ensure the objective exists
        Objective objective = objectiveRepository.findById(task.getObjective().getObjectiveId())
                .orElseThrow(() -> new IllegalArgumentException("Objective not found"));

        task.setObjective(objective);
        task.setTaskObjective(objective.getObjectiveName());  // ✅ Set non-null task_objective

        return taskRepository.save(task);
    }





    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }
}

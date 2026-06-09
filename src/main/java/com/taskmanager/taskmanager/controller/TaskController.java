package com.taskmanager.taskmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.service.TaskService;

@RestController
@RequestMapping("/tasks")
@CrossOrigin("*")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public Object getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task) {

        if (task.getTitle() == null ||
            task.getTitle().trim().isEmpty()) {

            return ResponseEntity
                    .badRequest()
                    .body("Task title cannot be empty");
        }

        return ResponseEntity.ok(
                taskService.createTask(task)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(
            @PathVariable Long id,
            @RequestBody Task task) {

        Task updated =
                taskService.updateTask(id, task);

        if (updated == null) {

            return ResponseEntity
                    .status(404)
                    .body("Task not found");
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(
            @PathVariable Long id) {

        boolean deleted =
                taskService.deleteTask(id);

        if (!deleted) {

            return ResponseEntity
                    .status(404)
                    .body("Task not found");
        }

        return ResponseEntity.ok(
                "Task deleted successfully"
        );
    }
}

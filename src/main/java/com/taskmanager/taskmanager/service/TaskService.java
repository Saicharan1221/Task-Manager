package com.taskmanager.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.model.Task;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    private Long nextId = 1L;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task createTask(Task task) {

        task.setId(nextId++);

        tasks.add(task);

        return task;
    }

    public Task updateTask(Long id, Task updatedTask) {

        for (Task task : tasks) {

            if (task.getId().equals(id)) {

                task.setTitle(updatedTask.getTitle());
                task.setCompleted(updatedTask.isCompleted());

                return task;
            }
        }

        return null;
    }

    public boolean deleteTask(Long id) {

        return tasks.removeIf(
                task -> task.getId().equals(id)
        );
    }
}
package com.stride.controller;

import com.stride.model.Task;
import com.stride.model.Project;
import com.stride.repository.TaskRepository;
import com.stride.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public TaskController(TaskRepository taskRepository, ProjectRepository projectRepository){
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;

    }

    //Get all the tasks
    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    //(Post) Add new tasks inside the project
    public Task createTask(@RequestParam Long projectId, @RequestParam String title){
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));


        Task task = new Task(title, project);
        return taskRepository.save(task);

    }


}

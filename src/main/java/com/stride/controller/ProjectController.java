package com.stride.controller;

import com.stride.model.Project;
import com.stride.repository.ProjectRepository;
import com.stride.repository.UserRepository; //Links project to a user
import com.stride.model.User;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/projects")


public class ProjectController {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    //Constructor injection
    public ProjectController(ProjectRepository projectRepository, UserRepository userRepository){
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    //Get all the projects
    @GetMapping
    public List<Project> getAllProject(){
        return projectRepository.findAll();
    }

    //Get Project by ID
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id){
        return projectRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    //Creates new project, the userId is required
    @PostMapping
    public ResponseEntity<Project> createProject(@Valid @RequestBody Project project, @RequestParam Long userId){
        return userRepository.findById(userId).map(user -> {project.setUser(user);
            return ResponseEntity.ok(projectRepository.save(project));
        }).orElse(ResponseEntity.badRequest().build());
    }

    //Update the project
    @PostMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @Valid @RequestBody Project projectDetails){
        return projectRepository.findById(id).map(project -> {
            project.setName(projectDetails.getName());
            project.setDescription(projectDetails.getDescription());
            project.setUpdatedAt(java.time.LocalDateTime.now());
            return ResponseEntity.ok(projectRepository.save(project));
        }).orElse(ResponseEntity.notFound().build());
    }

}
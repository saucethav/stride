package com.stride.model;

import jakarta.persistence.*; //JPA Annotations
import jakarta.validation.constraints.NotBlank; //Validation annotation
import java.time.LocalDateTime; //Timestamp handling

@Entity
@Table(name = "projects")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project name is required")
    private String name;

    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //Relationship since many projects can belong to one user
    @ManyToOne@JoinColumn(name = "user_id", nullable = false)
    private User user;


    //Constructors

    //Necessary Constructor
    public Project(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

    }

    //Convenience Constructor
    public Project(String name, String description, User user){
        this.name = name;
        this.description = description;
        this.user = user;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();


    }

    //Getters and Setters

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt){
        this.updatedAt = updatedAt;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }


}

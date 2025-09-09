package com.stride.model;

import jakarta.persistence.*; //Hibernate and JPA Annotation

@Entity
@Table(name = "tasks")

public class Task {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //Primary key

    @Column(nullable = false) //Required field
    private String title;

    @ManyToOne //Many tasks can belong to one project
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;


    //Necessary contructor
    public Task(){}

    //Convenience constructor
    public Task(String title, Project project){
        this.title = title;
        this.project = project;
    }

    //Getters and Setters

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Project getProject(){
        return project;
    }

    public void setProject(Project project){
        this.project = project;
    }


}

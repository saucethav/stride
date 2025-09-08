package com.stride.model;

import jakarta.persistence.*; //Access to @Entity and @Id
import jakarta.validation.constraints.Email; //Validates email format
import jakarta.validation.constraints.NotBlank; //Validates strings


@Entity // Tells hibernate this is a database table

@Table(name = "users") //Names the table





//Class for users
public class User {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generates ID incrementally
    private Long id;

    @NotBlank(message = "Name must not be blank")
    private String name; //Name of user

    @Email(message = "Email must be a valid email format")
    @NotBlank(message = "Email is required")

    @Column(unique = true, nullable = false) //Makes sure email is unique and email is required field

    private String email;

    //Default Constructor for JPA
    public User() {}


    //Convenience Constructor
    public User(String name, String email){
        this.name = name;
        this.email = email;

    }

    //Getters and Setters
    public Long getId(){
        return id;
    }
    //Sets id
    public void setId(Long id){
        this.id = id;
    }
    //Get name
    public String getName(){
        return name;
    }
    //Sets name
    public void setName(String name){
        this.name = name;
    }
    //Get email
    public String getEmail(){
        return email;
    }
    //Sets email
    public void setEmail(String email){
        this.email = email;
    }



}

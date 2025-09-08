package com.stride.repository;

import com.stride.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

//Gives access to all CRUD methods
public interface ProjectRepository extends JpaRepository<Project, Long> {

}

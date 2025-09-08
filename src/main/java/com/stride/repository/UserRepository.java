package com.stride.repository;

import com.stride.model.User; //Import User entity
import org.springframework.data.jpa.repository.JpaRepository; //JPA built-in repository interface


public interface UserRepository extends JpaRepository<User, Long>{

}

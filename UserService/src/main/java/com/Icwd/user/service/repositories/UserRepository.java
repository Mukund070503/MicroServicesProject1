package com.Icwd.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Icwd.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}

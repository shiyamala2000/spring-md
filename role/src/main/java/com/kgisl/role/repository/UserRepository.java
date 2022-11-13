package com.kgisl.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgisl.role.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByName(String name);
}

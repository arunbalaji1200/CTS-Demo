package com.cts.gsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.gsd.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{



}

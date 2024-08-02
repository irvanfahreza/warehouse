package com.warehouse.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warehouse.warehouse.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

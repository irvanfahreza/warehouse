package com.warehouse.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warehouse.warehouse.entity.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
}


package com.warehouse.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warehouse.warehouse.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}

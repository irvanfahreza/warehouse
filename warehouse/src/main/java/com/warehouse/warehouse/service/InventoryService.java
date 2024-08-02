package com.warehouse.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.warehouse.entity.Inventory;
import com.warehouse.warehouse.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventRepo;
	
	public Inventory addInvent(Inventory invent) {
		return inventRepo.save(invent);
	}
	
}

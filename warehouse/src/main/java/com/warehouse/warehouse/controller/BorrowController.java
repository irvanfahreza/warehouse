package com.warehouse.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.warehouse.entity.Borrow;
import com.warehouse.warehouse.entity.Inventory;
import com.warehouse.warehouse.entity.User;
import com.warehouse.warehouse.repository.InventoryRepository;
import com.warehouse.warehouse.repository.UserRepository;
import com.warehouse.warehouse.service.BorrowService;

@RestController
@RequestMapping("/borrowing")
public class BorrowController {
	
    @Autowired
    private BorrowService borrowService;
    
    @Autowired
    private InventoryRepository inventRepo;
    
    @Autowired
    private UserRepository userRepo;

    @PostMapping
    public ResponseEntity<String> borrowProduct(@RequestParam Long userId, @RequestParam Long inventoryId, @RequestParam int quantity) {
        User user = userRepo.findById(userId).orElseThrow();
        Inventory inventory = inventRepo.findById(inventoryId).orElseThrow();

        Borrow borrowing = borrowService.borrowProduct(user, inventory, quantity);
        return ResponseEntity.ok("Barang berhasil dipinjam");
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<String> returnProduct(@PathVariable Long id) {
    	Borrow borrowing = borrowService.returnProduct(id);
    	return ResponseEntity.ok("Barang berhasil dikembalikan");
    }
}


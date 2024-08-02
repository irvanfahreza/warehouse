package com.warehouse.warehouse.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.warehouse.entity.Borrow;
import com.warehouse.warehouse.entity.Inventory;
import com.warehouse.warehouse.entity.User;
import com.warehouse.warehouse.repository.BorrowRepository;
import com.warehouse.warehouse.repository.InventoryRepository;

@Service
public class BorrowService {
    @Autowired
    private BorrowRepository borrowRepo;

    @Autowired
    private InventoryRepository inventRepo;

    public Borrow borrowProduct(User user, Inventory inventory, int quantity) {
        if (inventory.getQuantity() < quantity) {
            throw new RuntimeException("Not enough inventory");
        }

        inventory.setQuantity(inventory.getQuantity() - quantity);
        inventRepo.save(inventory);

        Borrow borrowing = new Borrow();
        borrowing.setUser(user);
        borrowing.setInventory(inventory);
        borrowing.setQuantity(quantity);
        borrowing.setBorrowedAt(LocalDateTime.now());

        return borrowRepo.save(borrowing);
    }

    public Borrow returnProduct(Long borrowId) {
    	Borrow borrowing = borrowRepo.findById(borrowId).orElseThrow();
        Inventory inventory = borrowing.getInventory();
        inventory.setQuantity(inventory.getQuantity() + borrowing.getQuantity());
        inventRepo.save(inventory);

        borrowRepo.delete(borrowing);
        return borrowing;
    }
}

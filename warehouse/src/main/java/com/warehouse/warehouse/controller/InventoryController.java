package com.warehouse.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.warehouse.entity.Inventory;
import com.warehouse.warehouse.service.InventoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<String> addInvent(@RequestBody @Valid Inventory inventory) {
        Inventory savedInventory = inventoryService.addInvent(inventory);
        return ResponseEntity.ok("Barang Berhasil Ditambahkan");
    }

}


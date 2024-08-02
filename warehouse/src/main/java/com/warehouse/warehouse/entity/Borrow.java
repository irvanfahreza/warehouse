package com.warehouse.warehouse.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private Inventory inventory;

    @NotNull
    private int quantity;

    private LocalDateTime borrowedAt;

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public int getQuantity() {
		return quantity;
	}

	public LocalDateTime getBorrowedAt() {
		return borrowedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setBorrowedAt(LocalDateTime borrowedAt) {
		this.borrowedAt = borrowedAt;
	}

    
}

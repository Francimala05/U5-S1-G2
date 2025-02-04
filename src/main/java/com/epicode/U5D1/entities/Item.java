package com.epicode.U5D1.entities;

import lombok.Getter;

@Getter
public abstract class Item {
	protected int calories;
	protected double price;

	public Item(int calories, double price) {
		this.calories = calories;
		this.price = price;
	}

	// Metodo astratto per ottenere il prezzo, implementato nelle sottoclassi
	public abstract double getPrice();

	// Metodo astratto per ottenere le calorie, implementato nelle sottoclassi
	public abstract int getCalories();
}

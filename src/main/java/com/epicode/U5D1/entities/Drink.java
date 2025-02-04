package com.epicode.U5D1.entities;

import lombok.Getter;

@Getter
public class Drink extends Item {

	private String name;

	public Drink(String name, int calories, double price) {
		super(calories, price);  // Passiamo calorie e prezzo alla superclasse
		this.name = name;
	}

	// Implementazione del metodo getPrice
	@Override
	public double getPrice() {
		return price;
	}

	// Implementazione del metodo getCalories
	@Override
	public int getCalories() {
		return calories;
	}

	@Override
	public String toString() {
		return "Drink{" +
				"name='" + name + '\'' +
				", calories=" + calories +
				", price=" + price +
				'}';
	}
}

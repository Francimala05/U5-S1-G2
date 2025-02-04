package com.epicode.U5D1.entities;

import lombok.Getter;

import java.util.List;

@Getter
public class Pizza extends Item {

	private String name;
	private List<Topping> toppingList;
	private boolean isXl = false;

	public Pizza(String name, List<Topping> toppingList, boolean isXl) {
		super(1012, 4.3);  // Passiamo calorie e prezzo base alla superclasse
		this.name = name;
		this.toppingList = toppingList;
		this.isXl = isXl;
		this.calories = setCalories(toppingList, isXl);  // Calorie specifiche per questa pizza
		this.price = setPrice(toppingList, isXl);  // Prezzo specifico per questa pizza
	}

	// Metodo per calcolare le calorie (aggiungendo quelle dei toppings e considerando la versione XL)
	@Override
	public int getCalories() {
		return calories;
	}

	// Metodo per calcolare il prezzo (aggiungendo quello dei toppings e considerando la versione XL)
	@Override
	public double getPrice() {
		return price;
	}

	// Calcola le calorie della pizza, considerando i toppings e la versione XL
	private int setCalories(List<Topping> toppingList, boolean isXl) {
		int tot = 1012;  // Calorie base per una pizza
		if (toppingList != null) {
			for (Topping topping : toppingList) {
				tot += topping.getCalories();  // Aggiungi le calorie di ogni topping
			}
		}
		if (isXl) {
			tot += (tot * 5) / 100;  // Aumenta le calorie del 5% se è una pizza XL
		}
		return tot;
	}

	// Calcola il prezzo della pizza, considerando i toppings e la versione XL
	private double setPrice(List<Topping> toppingList, boolean isXl) {
		double tot = 4.30;  // Prezzo base per una pizza
		if (toppingList != null) {
			for (Topping topping : toppingList) {
				tot += topping.getPrice();  // Aggiungi il prezzo di ogni topping
			}
		}
		if (isXl) {
			tot += (tot * 10) / 100;  // Aumenta il prezzo del 10% se è una pizza XL
		}
		return tot;
	}

	@Override
	public String toString() {
		return "Pizza{" +
				"name='" + name + '\'' +
				", calories=" + calories +
				", price=" + price +
				", toppingList=" + toppingList +
				", isXl=" + isXl +
				'}';
	}
}

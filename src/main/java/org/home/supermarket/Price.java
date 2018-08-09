package org.home.supermarket;


import lombok.Data;

@Data
public class Price {

	private final double price;

	public Price(double price) {
		this.price = price;
	}

	public double total(double amount) {
		return price * amount;
	}

}

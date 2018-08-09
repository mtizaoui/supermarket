package org.home.supermarket;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Cassier {

	private List<Promotion> discounts = new ArrayList<Promotion>();
	
	public double total(Order cart) {
		double total = cart.total();
		
		for (Promotion discount : discounts) {
			total -= discount.discount(cart);
		}
		return total;
	}

	public void addDiscount(Promotion discount) {
		discounts.add(discount);
	}

}

package org.home.supermarket;

public class DiscountFactory {

	public static Discount getDisount(int discountUsed) {
		switch (discountUsed) {
		case 1:
			return new XForYDiscount();

		case 2:
			return new AmountForPriceDiscount();

		default:
			return null;

		}
	}

}

package org.home.supermarket;

import lombok.Data;

@Data
public class XForYDiscount implements Discount {

	private Article article;
	private double itemAmount;
	private double forAmount;

	public XForYDiscount(Article article, double xAmount, double yAmount) {
		this.article = article;
		this.itemAmount = xAmount;
		this.forAmount = yAmount;
	}

	public void initDiscount(Article article, double xAmount, double yAmount) {
		this.article = article;
		this.itemAmount = xAmount;
		this.forAmount = yAmount;
	}

	public XForYDiscount() {
		super();
	}

	@Override
	public double discount(Cart cart) {

		double amount = cart.getItemsByArticle(article).stream().mapToDouble(item -> item.getAmount()).sum();

		return (amount / itemAmount) * article.total(itemAmount - forAmount);

	}

}

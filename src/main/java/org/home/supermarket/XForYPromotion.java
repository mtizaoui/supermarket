package org.home.supermarket;

import lombok.Data;

@Data
public class XForYPromotion implements Promotion {

	private Article article;
	private double itemAmount;
	private double forAmount;

	public XForYPromotion(Article article, double xAmount, double yAmount) {
		this.article = article;
		this.itemAmount = xAmount;
		this.forAmount = yAmount;
	}

	public void initDiscount(Article article, double xAmount, double yAmount) {
		this.article = article;
		this.itemAmount = xAmount;
		this.forAmount = yAmount;
	}

	public XForYPromotion() {
		super();
	}

	@Override
	public double discount(Order cart) {

		double amount = cart.getItemsByArticle(article).stream().mapToDouble(item -> item.getAmount()).sum();

		return (amount / itemAmount) * article.total(itemAmount - forAmount);

	}

}

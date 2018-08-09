package org.home.supermarket;


import lombok.Data;

@Data
public class Item {

	private final Article article;
	private final double amount;

	public Item(Article article, double amount) {
		this.article = article;
		this.amount = amount;
	}

	public double total() {
		return article.total(amount);
	}


	public boolean isArticle(Article article) {
		return this.article.equals(article);
	}

}

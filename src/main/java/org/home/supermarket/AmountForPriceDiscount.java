package org.home.supermarket;

import java.util.List;
import lombok.Data;

@Data
public class AmountForPriceDiscount implements Discount {

	private Article article;
	private int amount;
	private Price price;

	public AmountForPriceDiscount(Article article, int amount, Price price) {
		this.article = article;
		this.amount = amount;
		this.price = price;
	}

	public void initAmountForPriceDiscount(Article article, int amount, Price price) {
		this.article = article;
		this.amount = amount;
		this.price = price;
	}

	public AmountForPriceDiscount() {
		super();
	}

	@Override
	public double discount(Cart cart) {
	
		List<Item> allItems = cart.getItemsByArticle(article);
		int numberOfItems  =(int)allItems.stream().mapToDouble(item->item.getAmount()).sum();
		
		return article.total(numberOfItems) - price.total(numberOfItems / amount);

	}

}

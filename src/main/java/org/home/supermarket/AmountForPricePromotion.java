package org.home.supermarket;

import java.util.List;
import lombok.Data;

@Data
public class AmountForPricePromotion implements Promotion {

	private Article article;
	private int amount;
	private Price price;

	public AmountForPricePromotion(Article article, int amount, Price price) {
		this.article = article;
		this.amount = amount;
		this.price = price;
	}

	public void initAmountForPriceDiscount(Article article, int amount, Price price) {
		this.article = article;
		this.amount = amount;
		this.price = price;
	}

	public AmountForPricePromotion() {
		super();
	}

	@Override
	public double discount(Order cart) {
	
		List<OrderLine> allItems = cart.getItemsByArticle(article);
		int numberOfItems  =(int)allItems.stream().mapToDouble(item->item.getAmount()).sum();
		
		return article.total(numberOfItems) - price.total(numberOfItems / amount);

	}

}

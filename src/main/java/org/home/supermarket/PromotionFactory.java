package org.home.supermarket;

public class PromotionFactory {

	private static MockArticles articles = MockArticles.getInstance();

	public static Promotion getPromotion(int discountUsed) {
		// these data normally are recoverable from the database

		switch (discountUsed) {
		case 1:
			return new XForYPromotion(articles.getArticle1(), 3, 2);

		case 2:
			return new AmountForPricePromotion(articles.getArticle1(), 3, new Price(2.5));

		default:
			return null;

		}
	}

}

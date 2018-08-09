package org.home.supermarket;

import org.home.supermarket.exception.OrderLineException;

import lombok.Data;

@Data
public class OrderLineBuilder {

	public OrderLineSpecifier create(Article article) {
		return new OrderLineSpecifier(article);
	}

	public static class OrderLineSpecifier {
		private Article article;
		private Double amount;

		public OrderLineSpecifier(Article article) {
			this.article = article;
		}

		public OrderLineSpecifier amount(int amount) {
			this.amount = (double) amount;
			return this;
		}

		public OrderLine build() throws Exception {
			if (article != null && article.getPrice() != null && amount != null) {
				return new OrderLine(article, amount);
			} else {
				throw new OrderLineException("To build an article object it is necessary to fill the price and the amount");
			}

		}

	}
}

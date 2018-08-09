package org.home.supermarket;


import lombok.Data;

@Data
public class OrderLineBuilder {

	public OrderLineSpecifier create(Article article) {
		return new OrderLineSpecifier(article);
	}

	public static class OrderLineSpecifier {
		private Article article;
		private double amount;
		
		public OrderLineSpecifier(Article article) {
			this.article = article;
		}

		public OrderLineSpecifier amount(int amount) {
			this.amount = amount;
			return this;
		}

		public OrderLine item() {
			return new OrderLine(article, amount);
		}
		
	}
}

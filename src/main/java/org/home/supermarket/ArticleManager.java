package org.home.supermarket;

import lombok.Data;

@Data
public class ArticleManager {

	private int nextId = 0;

	public Article article(double price) {
		nextId += 1;
		return new Article(nextId, new Price(price));
	}
	
}

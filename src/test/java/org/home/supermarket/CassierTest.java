package org.home.supermarket;



import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CassierTest {

	private MockArticles articles=MockArticles.getInstance();
	private OrderLineBuilder itemBuilder = new OrderLineBuilder();

	@Test
	public void testNoItems() {
		Cassier cassier = new Cassier();
		Order cart = new Order();
		double total = cassier.total(cart);
		assertEquals(0.0, total, 0.001);
	}

	@Test
	public void testOneItem() throws Exception {
		Cassier cassier = new Cassier();
		Order cart = new Order();
		cart.add(itemBuilder.create(articles.getArticle0()).amount(1).build());
		double total = cassier.total(cart);
		assertEquals(1.0, total, 0.001);
	}

	@Test
	public void testItems() throws Exception {
		Cassier cassier = new Cassier();
		Order cart = new Order();
		cart.add(itemBuilder.create(articles.getArticle0()).amount(1).build());
		cart.add(itemBuilder.create(articles.getArticle1()).amount(2).build());
		double total = cassier.total(cart);
		assertEquals(4.0, total, 0.001);
	}

	@Test
	public void test3For2() throws Exception {
		Cassier cassier = new Cassier();

		
		Promotion discount = (XForYPromotion) PromotionFactory.getPromotion(1);
	

		cassier.addDiscount(discount);
		Order cart = new Order();
		cart.add(itemBuilder.create(articles.getArticle0()).amount(1).build());
		cart.add(itemBuilder.create(articles.getArticle1()).amount(3).build());
		double total = cassier.total(cart);
		assertEquals(4.0, total, 0.001);
	}

	@Test
	public void test3ForPrice() throws Exception {
		Cassier cassier = new Cassier();

		Promotion promotion =  PromotionFactory.getPromotion(2);

		cassier.addDiscount(promotion);
		Order cart = new Order();
		cart.add(itemBuilder.create(articles.getArticle0()).amount(1).build());
		cart.add(itemBuilder.create(articles.getArticle1()).amount(3).build());
		double total = cassier.total(cart);
		assertEquals(3.5, total, 0.001);

	}
}

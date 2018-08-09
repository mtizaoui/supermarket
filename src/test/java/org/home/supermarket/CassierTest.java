package org.home.supermarket;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CassierTest {

	private ArticleManager articleFactory = new ArticleManager();
	private Article article0 = articleFactory.article(1.0);
	private Article article1 = articleFactory.article(1.5);
	private ItemBuilder itemBuilder = new ItemBuilder();

	@Test
	public void testNoItems() {
		Cassier cassier = new Cassier();
		Cart cart = new Cart();
		double total = cassier.total(cart);
		assertEquals(0.0, total, 0.001);
	}

	@Test
	public void testOneItem() {
		Cassier cassier = new Cassier();
		Cart cart = new Cart();
		cart.add(itemBuilder.create(article0).amount(1).item());
		double total = cassier.total(cart);
		assertEquals(1.0, total, 0.001);
	}

	@Test
	public void testItems() {
		Cassier cassier = new Cassier();
		Cart cart = new Cart();
		cart.add(itemBuilder.create(article0).amount(1).item());
		cart.add(itemBuilder.create(article1).amount(2).item());
		double total = cassier.total(cart);
		assertEquals(4.0, total, 0.001);
	}

	@Test
	public void test3For2() {
		Cassier cassier = new Cassier();

		XForYDiscount discount = (XForYDiscount) DiscountFactory.getDisount(1);
		discount.initDiscount(article1, 3, 2);

		cassier.addDiscount(discount);
		Cart cart = new Cart();
		cart.add(itemBuilder.create(article0).amount(1).item());
		cart.add(itemBuilder.create(article1).amount(3).item());
		double total = cassier.total(cart);
		assertEquals(4.0, total, 0.001);
	}

	@Test
	public void test3ForPrice() {
		Cassier cassier = new Cassier();

		AmountForPriceDiscount discount = (AmountForPriceDiscount) DiscountFactory.getDisount(2);
		discount.initAmountForPriceDiscount(article1, 3, new Price(2.5));
		cassier.addDiscount(discount);
		Cart cart = new Cart();
		cart.add(itemBuilder.create(article0).amount(1).item());
		cart.add(itemBuilder.create(article1).amount(3).item());
		double total = cassier.total(cart);
		assertEquals(3.5, total, 0.001);

	}
}

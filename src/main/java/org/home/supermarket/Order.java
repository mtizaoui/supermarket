package org.home.supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Order {

	private List<OrderLine> items = new ArrayList<OrderLine>();

	public void add(OrderLine item) {
		items.add(item);
	}

	public double total() {
		double total = 0.0;
		for (OrderLine item : items) {
			total += item.total();
		}
		return total;
	}

	public List<OrderLine> getItemsByArticle(Article article) {

		return items.stream().filter(item -> item.isArticle(article)).collect(Collectors.toList());

	}

}

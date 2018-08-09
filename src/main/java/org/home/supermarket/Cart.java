package org.home.supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Cart {

	private List<Item> items = new ArrayList<Item>();

	public void add(Item item) {
		items.add(item);
	}

	public double total() {
		double total = 0.0;
		for (Item item : items) {
			total += item.total();
		}
		return total;
	}

	public List<Item> getItemsByArticle(Article article) {

		return items.stream().filter(item -> item.isArticle(article)).collect(Collectors.toList());

	}

}

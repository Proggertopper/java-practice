package com.proggertopper.spring.springcore.shoppingcart;

import java.util.List;

public class ShoppingCart {
	
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "ShoppingCart [items=" + items + "]";
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}

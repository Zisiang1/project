package com.sddevops.project;

import java.util.ArrayList;


class CartCollection {
	
	private ArrayList<Cart> carts = new ArrayList<>();
	
	public CartCollection() {
    }
    
    // Add to cart
	public void addCart(Cart cart) {
    	carts.add(cart);
    }
	
	// Get cart
	public ArrayList<Cart> getCart() {
    	return carts;
    }
	
	// Delete cart
	public void deleteCart(Cart cart) {
    	carts.remove(cart);
    }

}
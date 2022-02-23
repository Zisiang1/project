package com.sddevops.project;

import java.util.ArrayList;
import java.util.List;

public class ProductCollection {
	
private ArrayList<Product> products = new ArrayList<>();
	
	public ProductCollection() {
		/*products.add(new Product("1","Title1","Author1","Description1", "Genre1", "Image1", "Price1"));
    	products.add(new Product("2","Title2","Author2","Description2", "Genre2", "Image2", "Price2"));
    	products.add(new Product("3","Title3","Author3","Description3", "Genre3", "Image3", "Price3"));*/
	}
	
	public List<Product> getProducts()
	{
		return products;
	}
	
	public void getProductByID()
	{
		products.get(0);
	}
	
    public void addProduct(Product product) 
    {
    	products.add(product);	
    }
}

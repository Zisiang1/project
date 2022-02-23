package com.sddevops.project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductCollectionTest {
	
	private ProductCollection pc;
	private Product p1;
	private Product p2;
	private final int PRODUCT_COLLECTION_SIZE = 2;

	@BeforeEach
	void setUp() throws Exception {
		pc = new ProductCollection();
		p1 = new Product(1,"Title1","Author1","Description1", "Genre1", "Image1", "Price1");
		p2 = new Product(2,"Title2","Author2","Description2", "Genre2", "Image2", "Price2");
		pc.addProduct(p1);
		pc.addProduct(p2);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetProducts() 
	{
		//fail("Not yet implemented");
		assertEquals(PRODUCT_COLLECTION_SIZE, pc.getProducts().size());
	}
	
	@Test
	void testGetProductByID()
	{
		List<Product> testSc = pc.getProducts();
		assertEquals(testSc.size(), PRODUCT_COLLECTION_SIZE);
		//pc.getProductByID(p1);
		pc.getProductByID();
		assertEquals(pc.getProducts().size(), PRODUCT_COLLECTION_SIZE);	
	}
	
	@Test
	void testAddProduct() 
	{
		//fail("Not yet implemented");
		List<Product> testSc = pc.getProducts();
		//Assert that Product Collection is equals to product collection size 2
		assertEquals(testSc.size(), PRODUCT_COLLECTION_SIZE);
		//Act
		pc.addProduct(p1);
		//Assert that Product Collection is equals to product collection size 2 + 1
		assertEquals(pc.getProducts().size(), PRODUCT_COLLECTION_SIZE+1);	
	}
}

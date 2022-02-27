package com.sddevops.project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author szisi
 *
 */
class CartCollectionTest {
	
	private CartCollection cc;
	private Cart c1;
	private Cart c2;
	private Cart c3;
	private Cart c4;
	private final int CART_COLLECTION_SIZE = 4;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		cc = new CartCollection();
		c1 = new Cart(1, 1, "user", "book", "img", "paid", "price", "quantity", "cost", "date");
		c2 = new Cart(2, 2, "user", "book", "img", "paid", "price", "quantity", "cost", "date");
		c3 = new Cart(3, 3, "user", "book", "img", "paid", "price", "quantity", "cost", "date");
		c4 = new Cart(4, 4, "user", "book", "img", "paid", "price", "quantity", "cost", "date");
		cc.addCart(c1);
		cc.addCart(c2);
		cc.addCart(c3);
		cc.addCart(c4);

		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.sddevops.project.CartCollection#addCart(com.sddevops.project.Cart)}.
	 */
	@Test
	void testAddCart() {
		//fail("Not yet implemented");
		List<Cart> testCc = cc.getCart();
		//Assert that cart Collection is equals to cart collection size 4
		assertEquals(testCc.size(), CART_COLLECTION_SIZE);
		//Act
		cc.addCart(c1);
		//Assert that cart Collection is equals to cart collection size 4 + 1
		assertEquals(cc.getCart().size(), CART_COLLECTION_SIZE+1);	
	}

	/**
	 * Test method for {@link com.sddevops.project.CartCollection#getCart()}.
	 */
	@Test
	void testGetCart() {
		//fail("Not yet implemented");
		assertEquals(4, cc.getCart().size());

	}

	/**
	 * Test method for {@link com.sddevops.project.CartCollection#deleteCart(com.sddevops.project.Cart)}.
	 */
	@Test
	void testDeleteCart() {
		//fail("Not yet implemented");
		List<Cart> testCc = cc.getCart();
		//Assert that cart Collection is equals to cart collection size 4
		assertEquals(testCc.size(), CART_COLLECTION_SIZE);
		//Act
		cc.deleteCart(c4);
		//Assert that cart Collection is equals to cart collection size 4 - 1
		assertEquals(cc.getCart().size(), CART_COLLECTION_SIZE-1);
	}

}

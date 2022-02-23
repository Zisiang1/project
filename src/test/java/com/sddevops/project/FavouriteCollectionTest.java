package com.sddevops.project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Desmond
 *
 */
class FavouriteCollectionTest {
	
	private FavouriteCollection fc;
	private Favourite f1;
	private Favourite f2;
	private final int favourite_collection_size = 2;

	@BeforeEach
	void setUp() throws Exception {
		fc = new FavouriteCollection();
		f1 = new Favourite("Brave New World", "Author Name", "User");
		f2 = new Favourite("Sapiens", "Author Name", "User");
		fc.addFavourites(f1);
		fc.addFavourites(f2);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetFavourites() {
		assertEquals(2, fc.getFavourites().size());
	}

	@Test
	void testAddFavourites() {
		List<Favourite> testFavouriteCollection = fc.getFavourites();
		assertEquals(testFavouriteCollection.size(), favourite_collection_size);
		fc.addFavourites(f1);
		assertEquals(fc.getFavourites().size(), favourite_collection_size + 1);
	}
	
	@Test
	void testDeleteFavourites()
	{
		List<Favourite> testFavouriteCollection = fc.getFavourites();
		assertEquals(fc.getFavourites().size(), favourite_collection_size);
		fc.deleteFavourites(f1);
		assertEquals(testFavouriteCollection.size(), favourite_collection_size - 1);
	}
}

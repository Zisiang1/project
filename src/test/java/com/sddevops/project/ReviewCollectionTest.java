/**
 * 
 */
package com.sddevops.project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author jaaxx
 *
 */
class ReviewCollectionTest {
	
	private ReviewCollection rc;
	private Review r1;
	private Review r2;
	private final int REVIEW_COLLECTION_SIZE = 2;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		rc = new ReviewCollection();
		r1 = new Review(1, "Test", "Good book", "4", "Book1", "1");
		r2 = new Review(2, "Test2", "Good book2", "3", "Book2", "2");
		rc.addReview(r1);
		rc.addReview(r2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.sddevops.project.ReviewCollection#getReviews()}.
	 */
	@Test
	void testGetReviews() {
		//fail("Not yet implemented");
		assertEquals(REVIEW_COLLECTION_SIZE, rc.getReviews().size());
	}

	/**
	 * Test method for {@link com.sddevops.project.ReviewCollection#addReview(com.sddevops.project.Review)}.
	 */
	@Test
	void testAddReview() {
		//fail("Not yet implemented");
		List<Review> testSc = rc.getReviews();
		assertEquals(testSc.size(), REVIEW_COLLECTION_SIZE);
		//Act
		rc.addReview(r1);
		//Assert that Product Collection is equals to product collection size 2 + 1
		assertEquals(rc.getReviews().size(), REVIEW_COLLECTION_SIZE+1);	
	}

	/**
	 * Test method for {@link com.sddevops.project.ReviewCollection#updateReview(com.sddevops.project.Review)}.
	 */
	@Test
	void testUpdateReview() {
		//fail("Not yet implemented");
		List<Review> testSc = rc.getReviews();
		assertEquals(testSc.size(), REVIEW_COLLECTION_SIZE);
		r2 = new Review(2, "Testing123", "Good book5", "4", "Book2", "2");
		rc.updateReview(r2);
		assertEquals(rc.getReviews().size(), REVIEW_COLLECTION_SIZE);
	}

	/**
	 * Test method for {@link com.sddevops.project.ReviewCollection#deleteReview(com.sddevops.project.Review)}.
	 */
	@Test
	void testDeleteReview() {
		//fail("Not yet implemented");
		List<Review> testSc = rc.getReviews();
		assertEquals(testSc.size(), REVIEW_COLLECTION_SIZE);
		//Act
		rc.deleteReview(r1);
		assertEquals(rc.getReviews().size(), REVIEW_COLLECTION_SIZE-1);	
	}

}

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
 * @author tayyu
 *
 */
class UserCollectionTest {
	private UserCollection uc;
	private User p1;
	private User p2;
	
	private User p3;
	private User p4;
	private final int USER_COLLECTION_SIZE = 4;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		uc = new UserCollection();
		p1 = new User("123","123","123","123","123","123","123","123","123","123");
		p2 = new User("123","123","123","123","123","123","123","123","123","123");
		p3 = new User("123","123","123","123","123","123","123","123","123","123");
		p4 = new User("123","123","123","123","123","123","123","123","123","123");
		uc.addUser(p1);
		uc.addUser(p2);
		uc.addUser(p3);
		uc.addUser(p4);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.sddevops.project.UserCollection#getUser()}.
	 */
	@Test
	void testGetUser() {
		assertEquals(USER_COLLECTION_SIZE, uc.getUser().size());
	}

	/**
	 * Test method for {@link com.sddevops.project.UserCollection#addUser(com.sddevops.project.User)}.
	 */
	@Test
	void testAddUser() {
		//fail("Not yet implemented");
				List<User> testSc = uc.getUser();
				//Assert that Product Collection is equals to product collection size 2
				assertEquals(testSc.size(), USER_COLLECTION_SIZE);
				//Act
				uc.addUser(p1);
				//Assert that Product Collection is equals to product collection size 2 + 1
				assertEquals(uc.getUser().size(), USER_COLLECTION_SIZE+1);	
	}

	/**
	 * Test method for {@link com.sddevops.project.UserCollection#deleteUser(com.sddevops.project.User)}.
	 */
	@Test
	void testDeleteUser() {
		List<User> testFavouriteCollection = uc.getUser();
		assertEquals(uc.getUser().size(), USER_COLLECTION_SIZE);
		uc.deleteUser(p1);
		assertEquals(testFavouriteCollection.size(), USER_COLLECTION_SIZE - 1);
	}

	/**
	 * Test method for {@link com.sddevops.project.UserCollection#getUserByName()}.
	 */
	@Test
	void testGetUserByName() {
		
		List<User> testSc = uc.getUser();
		assertEquals(testSc.size(), USER_COLLECTION_SIZE);
		
		uc.getUserByName();
		assertEquals(uc.getUser().size(), USER_COLLECTION_SIZE);	
	}

}

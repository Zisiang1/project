/**
 * 
 */
package com.sddevops.project;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jaaxx
 *
 */
public class ReviewCollection {
	
	private ArrayList<Review> reviews = new ArrayList<>();
	
	public ReviewCollection() {
		/* */
	}
	
	public List<Review> getReviews(){	
		return reviews;
	}
	
    public void addReview(Review review) 
    {
    	reviews.add(review);	
    }
    
    public void updateReview(Review review)
    {
    	reviews.set(0, review);
    }
    
    public void deleteReview(Review review) 
    {
    	reviews.remove(review);
    }

}

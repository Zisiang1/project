package com.sddevops.project;

import java.util.List;
import java.util.ArrayList;

public class FavouriteCollection {
	private ArrayList<Favourite> favourites = new ArrayList<>();

    public FavouriteCollection() {
    }
    
    //Fetch all favourite
    public List<Favourite> getFavourites() {
    	return favourites;
    }
    
    //Add favourite
    public void addFavourites(Favourite favourite) {
    	favourites.add(favourite);
    }
    
    //Delete favourite
    public void deleteFavourites(Favourite favourite) {
    	favourites.remove(favourite);
    }
};

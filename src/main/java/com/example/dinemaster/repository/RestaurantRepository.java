/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.dinemaster.repository;

import java.util.ArrayList;
import com.example.dinemaster.model.*;

public interface RestaurantRepository {
    public ArrayList<Restaurant> getRestarants();

    public Restaurant restaurantById(int restaurantId);

    public Restaurant addRestaurant(Restaurant restaurant);

    public Restaurant updateRestaurant(int restaurantId, Restaurant restaurant);

    public void deleteRestaurant(int restaurantId);

    public ArrayList<Chef> getChefs();

    public Chef addRestaurantChef(Chef chef);

    

}

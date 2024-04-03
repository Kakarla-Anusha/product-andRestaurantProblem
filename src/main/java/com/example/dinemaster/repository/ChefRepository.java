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

public interface ChefRepository {

    public ArrayList<Chef> getChefs();

    public Chef chefById(int chefId);

    public Chef addRestaurantChef(Chef chef);

    public Chef updateChefRestaurant(int chefId, Chef chef);

    public void deleteChef(int chefId);

    public Restaurant getRestaurantChef(int chefId);

}
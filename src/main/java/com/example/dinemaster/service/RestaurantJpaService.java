/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.dinemaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import com.example.dinemaster.repository.*;
import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.model.Chef;

@Service
public class RestaurantJpaService implements RestaurantRepository {
    @Autowired
    public RestaurantJpaRepository restaurantjparepository;

    @Autowired
    public ChefJpaRepository chefjparepository;

    @Override
    public ArrayList<Restaurant> getRestarants() {
        List<Restaurant> restaurantsList = restaurantjparepository.findAll();
        ArrayList<Restaurant> restaurants = new ArrayList<>(restaurantsList);
        return restaurants;
    }

    @Override
    public Restaurant restaurantById(int restaurantId) {
        try {
            Restaurant restaurant = restaurantjparepository.findById(restaurantId).get();
            return restaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        restaurantjparepository.save(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant updateRestaurant(int restaurantId, Restaurant restaurant) {

        try {
            Restaurant newRestaurant = restaurantjparepository.findById(restaurantId).get();
            if (restaurant.getName() != null) {
                newRestaurant.setName(restaurant.getName());
            }
            if (restaurant.getAddress() != null) {
                newRestaurant.setAddress(restaurant.getAddress());
            }
            if (restaurant.getCuisineType() != null) {
                newRestaurant.setCuisineType(restaurant.getCuisineType());
            }
            if (restaurant.getRating() != 0) {
                newRestaurant.setRating(restaurant.getRating());
            }
            restaurantjparepository.save(newRestaurant);
            return newRestaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        try {
            restaurantjparepository.deleteById(restaurantId);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}

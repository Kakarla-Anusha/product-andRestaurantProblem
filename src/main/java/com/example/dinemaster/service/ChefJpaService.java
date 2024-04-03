/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
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
import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;

@Service
public class ChefJpaService implements ChefRepository {
    @Autowired
    public ChefJpaRepository chefjparepository;

    @Autowired
    public RestaurantJpaRepository restaurantjparepository;

    @Override
    public ArrayList<Chef> getChefs() {
        List<Chef> chefList = chefjparepository.findAll();
        ArrayList<Chef> chefs = new ArrayList<>(chefList);
        return chefs;
    }

    @Override
    public Chef chefById(int chefId) {
        try {
            Chef chef = chefjparepository.findById(chefId).get();
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Chef addRestaurantChef(Chef chef) {
        Restaurant restaurant = chef.getRestaurant();
        int restaurantId = restaurant.getId();
        try {
            Restaurant newRestaurant = restaurantjparepository.findById(restaurantId).get();
            chef.setRestaurant(newRestaurant);
            chefjparepository.save(chef);
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Chef updateChefRestaurant(int chefId, Chef chef) {
        try {
            Chef newChef = chefjparepository.findById(chefId).get();
            if (chef.getFirstName() != null) {
                newChef.setFirstName(chef.getFirstName());
            }
            if (chef.getLastName() != null) {
                newChef.setLastName(chef.getLastName());
            }
            if (chef.getExpertise() != null) {
                newChef.setExpertise(chef.getExpertise());
            }
            if (chef.getExperienceYears() != 0) {
                newChef.setExperienceYears(chef.getExperienceYears());
            }
            if (chef.getRestaurant() != null) {
                Restaurant restaurant = chef.getRestaurant();
                int restaurantId = restaurant.getId();
                Restaurant newRestaurant = restaurantjparepository.findById(restaurantId).get();
                newChef.setRestaurant(newRestaurant);
            }
            chefjparepository.save(newChef);
            return newChef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override

    public void deleteChef(int chefId) {
        try {
            chefjparepository.deleteById(chefId);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);

    }

    @Override
    public Restaurant getRestaurantChef(int chefId) {
        try {
            Chef chef = chefjparepository.findById(chefId).get();
            Restaurant restaurant = chef.getRestaurant();
            return restaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}

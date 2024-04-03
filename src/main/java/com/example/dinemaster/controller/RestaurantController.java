/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.dinemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.dinemaster.service.*;
import com.example.dinemaster.model.*;

@RestController
public class RestaurantController {

    @Autowired
    public RestaurantJpaService restaurantjpaservice;

    @GetMapping("/restaurants")
    public ArrayList<Restaurant> getRestarants() {
        return restaurantjpaservice.getRestarants();
    }

    @GetMapping("/restaurants/{restaurantId}")
    public Restaurant restaurantById(@PathVariable("restaurantId") int restaurantId) {
        return restaurantjpaservice.restaurantById(restaurantId);
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantjpaservice.addRestaurant(restaurant);
    }

    @PutMapping("/restaurants/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable("restaurantId") int restaurantId,
            @RequestBody Restaurant restaurant) {
        return restaurantjpaservice.updateRestaurant(restaurantId, restaurant);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public void deleteRestaurant(@PathVariable("restaurantId") int restaurantId) {
        restaurantjpaservice.deleteRestaurant(restaurantId);
    }

}

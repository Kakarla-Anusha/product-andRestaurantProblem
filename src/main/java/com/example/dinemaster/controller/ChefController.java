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
import com.example.dinemaster.service.ChefJpaService;
import com.example.dinemaster.model.*;

@RestController
public class ChefController {

    @Autowired
    public ChefJpaService chefjpaservice;

    @GetMapping("/restaurants/chefs")
    public ArrayList<Chef> getChefs() {
        return chefjpaservice.getChefs();
    }

    @GetMapping("/restaurants/chefs/{chefId}")
    public Chef chefById(@PathVariable("chefId") int chefId) {
        return chefjpaservice.chefById(chefId);
    }

    @PostMapping("/restaurants/chefs")
    public Chef addRestaurantChef(@RequestBody Chef chef) {
        return chefjpaservice.addRestaurantChef(chef);
    }

    @PutMapping("/restaurants/chefs/{chefId}")
    public Chef updateChefRestaurant(@PathVariable("chefId") int chefId, @RequestBody Chef chef) {
        return chefjpaservice.updateChefRestaurant(chefId, chef);
    }

    @DeleteMapping("/restaurants/chefs/{chefId}")
    public void deleteChef(@PathVariable("chefId") int chefId) {
        chefjpaservice.deleteChef(chefId);
    }

    @GetMapping("/chefs/{chefId}/restaurant")
    public Restaurant getRestaurantChef(@PathVariable("chefId") int chefId) {
        return chefjpaservice.getRestaurantChef(chefId);
    }

}

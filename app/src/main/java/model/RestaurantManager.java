package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import model.Restaurant;

/**
 * Created by Mohammed on 3/26/2016.
 */
public class RestaurantManager {
    private static HashMap<String, Restaurant> restaurants;

    public RestaurantManager() {
        if(restaurants == null)
        restaurants = new HashMap<>();
    }

    public void addRestaurant(Restaurant r) {
        if (restaurants.containsKey(r.getRestaurantName())) {
            return;
        } else {
            restaurants.put(r.getRestaurantName(), r);
        }
    }

    public Restaurant newRestaurant(Restaurant r) {
        if (restaurants.containsKey(r.getRestaurantName())) {
            return restaurants.get(r.getRestaurantName());
        } else {
            restaurants.put(r.getRestaurantName(), r);
            return r;
        }
    }
}

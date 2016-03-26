package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jacob on 3/26/2016.
 */
public class Restaurant {

    String restaurantName;
    double restaurantRating;
    String restaurantDescription;
    Map<Disease, List<Double>> customRatings;



    public Restaurant(String name, double rating, String description){
        restaurantName = name;
        restaurantRating = rating;
        restaurantDescription = description;
        customRatings = new HashMap<>();
    }

    public String getRestaurantName(){
        return restaurantName;
    }

    public double getRestaurantCustomRating(Disease d){
        List<Double> disRatings = customRatings.get(d);
        double sum = 0;
        for(Double num : disRatings) {
            sum += num;
        }
        sum /= customRatings.size();
        return sum;
    }

    public void setRestaurantCustomeRating(Disease d, Double rating) {
        if(!customRatings.containsKey(d)) {
            customRatings.put(d, new ArrayList<Double>());
        }
        customRatings.get(d).add(rating);
    }

    public double getRestaurantRating() {
        return restaurantRating;
    }

    public String getRestauruntDescription(){
        return restaurantDescription;
    }
}

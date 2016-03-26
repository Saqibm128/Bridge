package hackgsu.tgd.restaurantsforchronicillness;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.location.places.Place;

import model.Disease;
import model.Restaurant;
import model.RestaurantManager;

public class RestaurantActivity extends AppCompatActivity {
    Restaurant r;
    Disease d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Place p = MainActivity.getPlace();
        String att = p.getAttributions()==null ? "" : p.getAttributions().toString();
        String name = p.getName()==null ? "" : p.getName().toString();
        r = new Restaurant(name, p.getRating(), att);
        RestaurantManager rm = new RestaurantManager();
        rm.addRestaurant(r);
        d = Disease.getCurrentDisease();
        setContentView(R.layout.activity_restaurant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView rDescription = (TextView) findViewById(R.id.restaurantName);
        rDescription.setText(r.getRestaurantName() + "\n" + r.getRestaurantDescription() + "\nRating: " + r.getRestaurantRating() + "\nRating for " + d.getDiseaseName() + " : ");
        final RatingBar ratingBar2 = (RatingBar) findViewById(R.id.diseaseRatingBar);
        Button b = (Button) findViewById(R.id.addRatingButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setRestaurantCustomRating(d, (double) ratingBar2.getNumStars());
            }
        });
    }

    public void onDirections(View v) {

    }


}

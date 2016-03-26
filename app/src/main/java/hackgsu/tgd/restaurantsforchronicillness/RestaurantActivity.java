package hackgsu.tgd.restaurantsforchronicillness;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import model.Disease;
import model.Restaurant;

public class RestaurantActivity extends AppCompatActivity {
    Restaurant r;
    Disease d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView rName = (TextView) findViewById(R.id.restaurantName);
        rName.setText(r.getRestaurantName());
        TextView dName = (TextView) findViewById(R.id.diseaseRatingTitle);
        dName.setText(d.getDiseaseName());
        TextView rDescription = (TextView) findViewById(R.id.restaurantDescription);
        rDescription.setText(r.getRestaurantDescription());

    }

}

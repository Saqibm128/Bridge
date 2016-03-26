package hackgsu.tgd.restaurantsforchronicillness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import model.Restaurant;

public class MapOrListActivity extends AppCompatActivity {
    private static Place p;
    private static final int PLACE_PICKER_REQUEST = 1;
    public void onClickMap(View view) {
//        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        getApplicationContext().startActivity(intent);
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        LatLngBounds l = LatLngBounds.builder().include(new LatLng(33.767, -84.39)).build();
        builder.setLatLngBounds(l);
        try {
            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
        } catch (Exception e) {
            Log.e("Error", e.getStackTrace().toString());
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);
                String toastMsg = String.format("Place: %s", place.getName());
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
                Intent i = new Intent(this, RestaurantActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                p = place;
                startActivity(i);
            }
        }
    }

    public static Place getPlace() {
        return p;
    }

    public void onClickList(View view) {
//        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        getApplicationContext().startActivity(intent);
        Toast t = Toast.makeText(this, "Not Available Yet", Toast.LENGTH_LONG);
        t.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_or_list);
    }
}

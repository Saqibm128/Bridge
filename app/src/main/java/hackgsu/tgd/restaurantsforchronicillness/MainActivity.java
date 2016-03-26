package hackgsu.tgd.restaurantsforchronicillness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.ArrayList;

import model.Disease;

public class MainActivity extends AppCompatActivity {

    private ListView diseaseList;
    private int PLACE_PICKER_REQUEST = 1;
    private static Place p;
    private Activity a;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = this;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, new ArrayList<Disease>());
        diseaseList = (ListView) findViewById(R.id.listView);
        diseaseList.setAdapter(adapter);
        adapter.add(new Disease("Diabetes", "Low Insulin Production or Ineffective Insulin"));
        adapter.add(new Disease("Celiac", "Must limit amount of gluten intake"));

        diseaseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((Disease) adapter.getItem(position)).setCurrentDisease();
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                LatLngBounds l = LatLngBounds.builder().include(new LatLng(33.573, -84.385)).build();
                builder.setLatLngBounds(l);
                try {
                    startActivityForResult(builder.build(a), PLACE_PICKER_REQUEST);
                } catch (Exception e) {
                    Log.e("Error", e.getStackTrace().toString());
                }
            }

            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (requestCode == PLACE_PICKER_REQUEST) {
                    if (resultCode == RESULT_OK) {
                        Place place = PlacePicker.getPlace(getApplicationContext(), data);
                        String toastMsg = String.format("Place: %s", place.getName());
                        Toast.makeText(getApplicationContext(), toastMsg, Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), RestaurantActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        p = place;
                        startActivity(i);
                    }
                }
            }
        });
    }

    public static Place getPlace() {
        return p;
    }


}

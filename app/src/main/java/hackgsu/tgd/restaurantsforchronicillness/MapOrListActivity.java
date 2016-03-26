package hackgsu.tgd.restaurantsforchronicillness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MapOrListActivity extends AppCompatActivity {

    public void onClickMap(View view) {
        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
    }

    public void onClickList(View view) {
        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_or_list);
    }
}

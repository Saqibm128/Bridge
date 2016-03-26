package hackgsu.tgd.restaurantsforchronicillness;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import model.Disease;

public class MainActivity extends AppCompatActivity {

    private ListView diseaseList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                Intent intent = new Intent(getApplicationContext(), MapOrListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ((Disease) adapter.getItem(position)).setCurrentDisease();
                getApplicationContext().startActivity(intent);
            }
        });
    }

}

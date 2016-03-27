package hackgsu.tgd.restaurantsforchronicillness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TrueActivity extends AppCompatActivity {
    private static String username;

    public static String getUsername(){
        return username;
    }

    public void nextButton(View bla){

        EditText name = (EditText)findViewById(R.id.editText);
        String user = name.getText().toString();
        username = user;

        Intent intent = new Intent(this, IntroActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true);
    }
}

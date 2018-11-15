package edu.sti.davaodurian.e_rrigate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    /**initialization for spinner
    Spinner spinner_irrigation;

    public static String[] irrigation  = {
            "Drip Irrigation",
            "Sprinkler Irrigation"
    };**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();

        /**spinner_irrigation = (Spinner) findViewById(R.id.spinner_irrigation);
        spinner_irrigation.setAdapter(new CustomAdapter(this, irrigation));**/
    }
}

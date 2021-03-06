package edu.sti.davaodurian.e_rrigate;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Profile extends AppCompatActivity implements View.OnClickListener {

    ImageButton img1;
    ImageButton img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();

        img1 = (ImageButton) findViewById(R.id.imgBtnHome);
        img1.setOnClickListener(this);

        img2 = (ImageButton) findViewById(R.id.imgBtnMonitor);
        img2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intentHome = new Intent(this, Home.class);
        startActivity(intentHome);

        Intent intentMonitor = new Intent(this, Monitor.class);
        startActivity(intentMonitor);
    }
}


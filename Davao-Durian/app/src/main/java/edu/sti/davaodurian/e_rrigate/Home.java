package edu.sti.davaodurian.e_rrigate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

   // private static final String TAG = "Home Activity";
    private boolean toggleButtonValue = false;
    private DatabaseReference mDatabase; //variable for Database Reference

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();

        ToggleButton toggleButton = findViewById(R.id.toggle_button);

        toggleButtonValue = toggleButton.isChecked();

        toggleButton.setOnCheckedChangeListener(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        Spinner spinner = findViewById(R.id.spinner_irrigation);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.irrigation, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        int value = 0;

        switch (id){
            case R.id.toggle_button:
                toggleButtonValue = isChecked;
                value = isChecked ? 1 : 0;
                break;
        }
        mDatabase.child("arduinoDevice").child("Switch").setValue(value); // Insert Data to Realtime Database: arduinoDevice/switch=value;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


package com.example.jhyuk.ma_whereiserror;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button SearchButton;
    Intent intent;
    ArrayAdapter adapter1;
    ArrayAdapter adapter2;
    Spinner startSpinner;
    Spinner endSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startSpinner = (Spinner) findViewById(R.id.StartSpinner);
        adapter1 = ArrayAdapter.createFromResource(this, R.array.building, android.R.layout.simple_spinner_dropdown_item);
        startSpinner.setAdapter(adapter1);

        endSpinner = (Spinner) findViewById(R.id.EndSpinner);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.building, android.R.layout.simple_spinner_dropdown_item);
        endSpinner.setAdapter(adapter2);

        SearchButton = (Button) findViewById(R.id.SearchButton);

        SearchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
    }


}

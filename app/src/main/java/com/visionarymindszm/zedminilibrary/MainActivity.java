package com.visionarymindszm.zedminilibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText pickDistrictEditText = findViewById(R.id.pickDistrictEditText);
        EditText pickProvinceEditText = findViewById(R.id.pickProvinceEditText);

        pickProvinceEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
package com.visionarymindszm.zedminilibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.visionarymindszm.zededitoptions.ZedUtils;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText pickDistrictEditText = findViewById(R.id.pickDistrictEditText);
        final EditText pickProvinceEditText = findViewById(R.id.pickProvinceEditText);

        pickProvinceEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZedUtils.showDialog("Select Province", MainActivity.this, ZedUtils.PROVINCES, pickProvinceEditText);
            }
        });

        pickDistrictEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pickProvinceEditText.getText().toString().isEmpty()) {
                    pickDistrictEditText.setText("Please select a province");
                }else{
                    ZedUtils.showDialog("Select District From "+pickProvinceEditText.getText().toString(), MainActivity.this,
                            ZedUtils.getDistrictArray(pickProvinceEditText.getText().toString()), pickDistrictEditText);
                }

            }
        });

    }
}
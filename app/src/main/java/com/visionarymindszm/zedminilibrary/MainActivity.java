package com.visionarymindszm.zedminilibrary;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.visionarymindszm.zededitoptions.ZedUtils;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText pickDistrictEditText = findViewById(R.id.pickDistrictEditText);
        final EditText pickProvinceEditText = findViewById(R.id.pickProvinceEditText);
//        Toast.makeText(this, new CountriesUtils(), Toast.LENGTH_LONG).show();
        pickProvinceEditText.setOnClickListener(view -> ZedUtils.showDialog("Select Province", MainActivity.this, ZedUtils.PROVINCES, pickProvinceEditText));

        pickDistrictEditText.setOnClickListener(view -> {
            if (pickProvinceEditText.getText().toString().isEmpty()) {
                pickDistrictEditText.setText("Please select a province");
            }else{
                ZedUtils.showDialog("Select District From "+pickProvinceEditText.getText().toString(), MainActivity.this,
                        ZedUtils.getDistrictArray(pickProvinceEditText.getText().toString()), pickDistrictEditText);
            }

        });

    }
}
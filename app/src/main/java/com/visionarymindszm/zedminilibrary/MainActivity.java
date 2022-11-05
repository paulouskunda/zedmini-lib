package com.visionarymindszm.zedminilibrary;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.visionarymindszm.zededitoptions.ZedUtils;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText pickDistrictEditText = findViewById(R.id.pickDistrictEditText);
        EditText pickProvinceEditText = findViewById(R.id.pickProvinceEditText);
        EditText nrcNumber = findViewById(R.id.nrcNumber);
        Button validateFields = findViewById(R.id.validateFields);
        pickProvinceEditText.setOnClickListener(view -> ZedUtils.INSTANCE.showDialog("Select Province", MainActivity.this, ZedUtils.INSTANCE.getPROVINCES(), pickProvinceEditText));

        pickDistrictEditText.setOnClickListener(view -> {
            if (pickProvinceEditText.getText().toString().isEmpty()) {
                pickDistrictEditText.setText("Please select a province");
            }else{
                ZedUtils.INSTANCE.showDialog("Select District From "+pickProvinceEditText.getText().toString(), MainActivity.this,
                        ZedUtils.INSTANCE.getDistrictArray(pickProvinceEditText.getText().toString()), pickDistrictEditText);
            }
        });

        ZedUtils.INSTANCE.nrcValidation(nrcNumber);

        EditText[] editTexts = {pickDistrictEditText, pickProvinceEditText, nrcNumber};
        validateFields.setOnClickListener(v -> {
            boolean isAllCool =  ZedUtils.INSTANCE.validateEditFields(getResources(), editTexts);
            if (isAllCool){
                Toast.makeText(getApplicationContext(), "All Good", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
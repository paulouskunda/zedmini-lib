# zedmini-lib
This is a Library to help with Provinces and Districts in Zambia and also provide a dialog to use if you want to have Options.
[![](https://jitpack.io/v/paulouskunda/zedmini-lib.svg)](https://jitpack.io/#paulouskunda/zedmini-lib/)

<br/>
ZedMini-Lib is a library that helps implement selection of provinces and district within Zambia on your behalf.
<br />
## GET-STARTED
ZedMini is distributed through [JitPack](https://jitpack.io/#paulouskunda/zedmini-lib).


To use it you need to add the following gradle dependency to your `build.gradle` file of the module where you want to use ZedMini (NOT the root file).

```groovy
repositories {
    maven { url "https://jitpack.io" }
}
```

```groovy
dependencies {
    implementation 'com.github.paulouskunda:zedmini-lib:v0.1.1'
}
```

# Basic Usage

```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText pickDistrictEditText = findViewById(R.id.pickDistrictEditText);
        final EditText pickProvinceEditText = findViewById(R.id.pickProvinceEditText);
        
        // display a dialog with provinces
        pickProvinceEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZedUtils.showDialog("Select Province", MainActivity.this, ZedUtils.PROVINCES, pickProvinceEditText);
            }
        });
        
        // display a dialog with districts from a selected province
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
```

## Using Library to Pass your custom options
```java
      final String[] bloodGroups = {"A+", "B+", "O+", "AB+", "A-", "B-", "O-", "A-"};
      
      bloodGroupField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZedUtils.showDialog("Select Blood Group", SignUp.this, bloodGroups, bloodGroupField);
            }
        });
```

### Happy Coding

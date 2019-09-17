package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    Spinner measurementSpinner;
    Spinner currencySpinner;
    private TextView result;
    private EditText distance, price, fuel;
    private Button calculateButton;
    private int Result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        measurementSpinner = findViewById(R.id.measurementSpinner);
        currencySpinner = findViewById(R.id.currencySpinner);
        distance = findViewById(R.id.distance);
        fuel = findViewById(R.id.fuel);
        price = findViewById(R.id.price);
        calculateButton = findViewById(R.id.calculateButton);
        result = findViewById(R.id.result);

        //measurement
        ArrayAdapter<CharSequence> measurementAdapter = ArrayAdapter.createFromResource(this, R.array.measurement, android.R.layout.simple_spinner_item);
        measurementAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        measurementSpinner.setAdapter(measurementAdapter);

        //currency
        ArrayAdapter<CharSequence> currencyAdapter = ArrayAdapter.createFromResource(this, R.array.currency, android.R.layout.simple_spinner_item);
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(currencyAdapter);

        final Integer selectedMeasurement = measurementSpinner.getSelectedItemPosition();
        final Integer selectedCurrency = currencySpinner.getSelectedItemPosition();

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int distanceInt = Integer.parseInt(distance.getText().toString());
                int priceInt = Integer.parseInt(price.getText().toString());
                int fuelInt = Integer.parseInt(fuel.getText().toString());

                Result = distanceInt + priceInt + fuelInt;

                    result.setText(String.valueOf(Result));
            }
        });
    }

}
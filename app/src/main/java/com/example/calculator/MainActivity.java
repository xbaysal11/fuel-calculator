package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner measurementSpinner;
    Spinner currencySpinner;
    private TextView result;
    private EditText distance, price, fuel;
    private Button calculateButton;
    private double fuelConsumption = 0;
    private double fuelConsumption2 = 0;
    private double fuelCost = 0;
    private double fuelCost2 = 0;
    int measurementId;
    int currencyId;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, measurementSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, currencySpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

        measurementId = measurementSpinner.getSelectedItemPosition();
        currencyId = currencySpinner.getSelectedItemPosition();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Nothing Selected, Baike", Toast.LENGTH_SHORT).show();

    }

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
        measurementSpinner.setOnItemSelectedListener(this);

        //currency
        ArrayAdapter<CharSequence> currencyAdapter = ArrayAdapter.createFromResource(this, R.array.currency, android.R.layout.simple_spinner_item);
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(currencyAdapter);
        currencySpinner.setOnItemSelectedListener(this);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float distanceInt = Float.parseFloat(distance.getText().toString());
                float priceInt = Float.parseFloat(price.getText().toString());
                float fuelInt = Float.parseFloat(fuel.getText().toString());

                if (measurementId == 0 && currencyId == 0){
                    fuelConsumption = fuelInt / distanceInt * 100 ;
                    fuelConsumption2 = distanceInt / fuelInt  ;
                    fuelCost = priceInt / fuelConsumption;
                    fuelCost2 = 1 / fuelCost;
                    result.setText("Fuel consumption: " + String.format("%.2f",fuelConsumption) + " Liters per 100km ("+String.format("%.2f",fuelConsumption2) +" km per liter)\nFuel cost: " + String.format("%.2f",fuelCost) +" KGS. per km ("+String.format("%.2f",fuelCost2)+" km per KGS)");
                }
                if (measurementId == 1 && currencyId == 0){
                    fuelConsumption = fuelInt / distanceInt * 100 ;
                    fuelConsumption2 = distanceInt / fuelInt  ;
                    fuelCost = priceInt / fuelConsumption;
                    fuelCost2 = 1 / fuelCost;
                    result.setText("Fuel consumption: " + String.format("%.2f",fuelConsumption) + " Miles per Gallon\nFuel cost: " + String.format("%.2f",fuelCost) +" KGS. per miles ("+String.format("%.2f",fuelCost2)+" miles per KGS)");
                }
                if (measurementId == 1 && currencyId == 1){
                    fuelConsumption = fuelInt / distanceInt * 100 ;
                    fuelConsumption2 = distanceInt / fuelInt  ;
                    fuelCost = priceInt / fuelConsumption;
                    fuelCost2 = 1 / fuelCost;
                    result.setText("Fuel consumption: " + String.format("%.2f",fuelConsumption) + " Miles per Gallon\nFuel cost: " + String.format("%.2f",fuelCost) +" $. per mile ("+String.format("%.2f",fuelCost2)+" mile per $)");
                }
                if (measurementId == 0 && currencyId == 1){
                    fuelConsumption = fuelInt / distanceInt * 100 ;
                    fuelConsumption2 = distanceInt / fuelInt  ;
                    fuelCost = priceInt / fuelConsumption;
                    fuelCost2 = 1 / fuelCost;
                    result.setText("Fuel consumption: " + String.format("%.2f",fuelConsumption) + " Liters per 100km ("+String.format("%.2f",fuelConsumption2) +" km per liter)\nFuel cost: " + String.format("%.2f",fuelCost) +" $. per km ("+String.format("%.2f",fuelCost2)+" km per $)");
                }

            }
        });
    }


}
package com.example.unitconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private Button btnCalc, btnConvert, btnConvert2;
    private Spinner dropDownFrom, dropDownTo, dropDownCurrencyFrom, dropDownCurrencyTo;
    EditText editCurrencyNumber, editUnitNumber;
    String From, To, fromUnit, toUnit;
    TextView resultCurrency, resultUnit;
    Double tot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Buttons
        btnCalc = (Button) findViewById(R.id.btnCalc);
        btnConvert = (Button) findViewById(R.id.btnConvert);
        btnConvert2 = (Button) findViewById(R.id.btnConvert2);
        //Conversion Result
        resultCurrency = findViewById(R.id.resultCurrency);
        resultUnit = findViewById(R.id.resultUnit);
        editCurrencyNumber = (EditText) findViewById(R.id.editCurrencyNumber);
        editUnitNumber = (EditText) findViewById(R.id.editUnitNumber);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCalc();
            }
        });

        //DropDown List for weight
        dropDownFrom = findViewById(R.id.dropDownFrom);
        dropDownTo = findViewById(R.id.dropDownTo);

        String[] menuList = getResources().getStringArray(R.array.measurement_units);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, menuList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //DropDown List for Unit
        dropDownFrom.setAdapter(adapter);
        dropDownTo.setAdapter(adapter);

        //DropDown List for currency
        dropDownCurrencyFrom = findViewById(R.id.dropDownCurrencyFrom);
        dropDownCurrencyTo = findViewById(R.id.dropDownCurrencyTo);

        String[] currencyList = getResources().getStringArray(R.array.currency_index);
        ArrayAdapter currency = new ArrayAdapter(this, android.R.layout.simple_spinner_item, currencyList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropDownCurrencyFrom.setAdapter(currency);
        dropDownCurrencyTo.setAdapter(currency);


        //Making convert button work (Convert Unit)
        btnConvert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double unit;
                if (editUnitNumber.getText().toString().matches("")){
                    unit = 0.00;
                }
                else
                {
                    unit= Double.parseDouble(editUnitNumber.getText().toString());
                }
                fromUnit = dropDownFrom.getSelectedItem().toString();
                toUnit = dropDownTo.getSelectedItem().toString();

                if (fromUnit.matches("Gram") && toUnit.matches("Kilogram")){
                    tot = unit * 0.001;
                    resultUnit.setText(tot.toString());

                }
                else if (fromUnit.matches("Gram") && toUnit.matches("Milligram")){
                    tot = unit * 1000;
                    resultUnit.setText(tot.toString());
                }
                else if (fromUnit.matches("Gram") && toUnit.matches("Gram")){
                    tot = unit * 1;
                    resultUnit.setText(tot.toString());
                }
               else if (fromUnit.matches("Kilogram") && toUnit.matches("Kilogram")){
                    tot = unit * 1;
                    resultUnit.setText(tot.toString());

                }
                else if (fromUnit.matches("Kilogram") && toUnit.matches("Milligram")){
                    tot = unit * 1000000;
                    resultUnit.setText(tot.toString());
                }
                else if (fromUnit.matches("Kilogram") && toUnit.matches("Gram")){
                    tot = unit * 1000;
                    resultUnit.setText(tot.toString());
                }
                else if (fromUnit.matches("Milligram") && toUnit.matches("Kilogram")){
                    tot = unit * 0.000001;
                    resultUnit.setText(tot.toString());

                }
                else if (fromUnit.matches("Milligram") && toUnit.matches("Milligram")){
                    tot = unit * 1;
                    resultUnit.setText(tot.toString());
                }
                else if (fromUnit.matches("Milligram") && toUnit.matches("Gram")){
                    tot = unit * 0.001;
                    resultUnit.setText(tot.toString());
                }

            }
        });

        //Convert Currency

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double amount;
                if (editCurrencyNumber.getText().toString().matches("")){
                     amount = 0.00;
                }
                else
                {
                    amount= Double.parseDouble(editCurrencyNumber.getText().toString());
                }
                From = dropDownCurrencyFrom.getSelectedItem().toString();
                To = dropDownCurrencyTo.getSelectedItem().toString();


                if (From.matches("USD") && To.matches("NRS")){
                    tot = amount * 117.31;
                    resultCurrency.setText(tot.toString());

                }
                else if (From.matches("USD") && To.matches("AUD")){
                    tot = amount * 1.35;
                    resultCurrency.setText(tot.toString());
                }
                else if (From.matches("USD") && To.matches("INR")){
                    tot = amount * 73.11;
                    resultCurrency.setText(tot.toString());
                }
                else if (From.matches("USD") && To.matches("USD") ) {
                    tot = amount * 1;
                    resultCurrency.setText(tot.toString());
                }
               else if (From.matches("NRS") && To.matches("NRS")){
                    tot = amount * 1;
                    resultCurrency.setText(tot.toString());

                }
                else if (From.matches("NRS") && To.matches("AUD")){
                    tot = amount * 0.011;
                    resultCurrency.setText(tot.toString());
                }
                else if (From.matches("NRS")&& To.matches("INR")){
                    tot = amount * 0.62;
                    resultCurrency.setText(tot.toString());
                }
                else if (From.matches("NRS") && To.matches("USD") ) {
                    tot = amount * 0.0085;
                    resultCurrency.setText(tot.toString());
                }
                else if (From.matches("AUD") && To.matches("NRS")){
                    tot = amount * 86.36;
                    resultCurrency.setText(tot.toString());

                }
                else if (From.matches("AUD") && To.matches("AUD")){
                    tot = amount * 1;
                    resultCurrency.setText(tot.toString());
                }
                else if (From.matches("AUD") && To.matches("INR")){
                    tot = amount * 53.82;
                    resultCurrency.setText(tot.toString());
                }
                else if (From.matches("AUD") && To.matches("USD") ) {
                    tot = amount * 0.73;
                    resultCurrency.setText(tot.toString());
                }
                else if (From.matches("INR") && To.matches("NRS")){
                    tot = amount * 1.6;
                    resultCurrency.setText(tot.toString());

                }
                else if (From.matches("INR") && To.matches("AUD")){
                    tot = amount * 0.018;
                    resultCurrency.setText(tot.toString());
                }
                else if (From.matches("INR") && To.matches("INR")){
                    tot = amount * 1;
                    resultCurrency.setText(tot.toString());
                }
                else if (From.matches("INR") && To.matches("USD") ) {
                    tot = amount * 0.013;
                    resultCurrency.setText(tot.toString());
                }
            }
        });
    }
    public void btnCalc(){
        Intent intent =new Intent(this, calculator.class);
        startActivity(intent);
    }
}
package com.example.unitconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.faendir.rhino_android.RhinoAndroidHelper;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;


public class calculator extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSub, btnMul, btnDiv, btnC, btnD, btnEq;
    TextView Result, info;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        setupUIViews();

        btn0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + "9");
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + ".");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + "-");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + "+");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + "×");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = info.getText().toString();
                info.setText(process + "÷");
            }
        });

        btnEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = info.getText().toString();

                if (process.length() > 0) {

                    process = process.replaceAll("×", "*");
                    process = process.replaceAll("÷", "/");

                    Context rhino = Context.enter();

                    rhino.setOptimizationLevel(-1);

                    String finalResult = "";

                    try {
                        Scriptable scriptable = rhino.initStandardObjects();
                        finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
                    } catch (Exception e) {
                        finalResult = "0";
                    }

                    Result.setText(finalResult);
                }
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText("");
                Result.setText("");
            }
        });


    }

    private void setupUIViews(){
        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btnC = (Button)findViewById(R.id.btnC);
        btnD = (Button)findViewById(R.id.btnD);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSub = (Button)findViewById(R.id.btnSub);
        btnMul = (Button)findViewById(R.id.btnMul);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        btnEq = (Button)findViewById(R.id.btnEq);
        Result = (TextView) findViewById(R.id.textResult);
        info = (TextView) findViewById(R.id.textControl);
    }

}
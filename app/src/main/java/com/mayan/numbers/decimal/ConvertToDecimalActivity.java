package com.mayan.numbers.decimal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConvertToDecimalActivity extends AppCompatActivity {

    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, clear_btn, equals_btn;
    EditText decimalNumbersText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_2decimal);
        b0 = findViewById(R.id.n0_btn);
        b1 = findViewById(R.id.n1_btn);
        b2 = findViewById(R.id.n2_btn);
        b3 = findViewById(R.id.n3_btn);
        b4 = findViewById(R.id.n4_btn);
        b5 = findViewById(R.id.n5_btn);
        b6 = findViewById(R.id.n6_btn);
        b7 = findViewById(R.id.n7_btn);
        b8 = findViewById(R.id.n8_btn);
        b9 = findViewById(R.id.n9_btn);
        b10 = findViewById(R.id.n10_btn);
        b11 = findViewById(R.id.n11_btn);
        b12 = findViewById(R.id.n12_btn);
        b13 = findViewById(R.id.n13_btn);
        b14 = findViewById(R.id.n14_btn);
        b15 = findViewById(R.id.n15_btn);
        b16 = findViewById(R.id.n16_btn);
        b17 = findViewById(R.id.n17_btn);
        b18 = findViewById(R.id.n18_btn);
        b19 = findViewById(R.id.n19_btn);
        clear_btn = findViewById(R.id.clear_btn);
        equals_btn = findViewById(R.id.equals_btn);
        decimalNumbersText = findViewById(R.id.decimal_numbers_text);
        decimalNumbersText.setEnabled(false);
        setActions();
    }

    private void setActions() {
        clear_btn.setOnClickListener(l -> decimalNumbersText.setText(""));
        equals_btn.setOnClickListener(l -> calculateNumber());
        b0.setOnClickListener(l -> addNumber("0"));
        b1.setOnClickListener(l -> addNumber("1"));
        b2.setOnClickListener(l -> addNumber("2"));
        b3.setOnClickListener(l -> addNumber("3"));
        b4.setOnClickListener(l -> addNumber("4"));
        b5.setOnClickListener(l -> addNumber("5"));
        b6.setOnClickListener(l -> addNumber("6"));
        b7.setOnClickListener(l -> addNumber("7"));
        b8.setOnClickListener(l -> addNumber("8"));
        b9.setOnClickListener(l -> addNumber("9"));
        b10.setOnClickListener(l -> addNumber("10"));
        b11.setOnClickListener(l -> addNumber("11"));
        b12.setOnClickListener(l -> addNumber("12"));
        b13.setOnClickListener(l -> addNumber("13"));
        b14.setOnClickListener(l -> addNumber("14"));
        b15.setOnClickListener(l -> addNumber("15"));
        b16.setOnClickListener(l -> addNumber("16"));
        b17.setOnClickListener(l -> addNumber("17"));
        b18.setOnClickListener(l -> addNumber("18"));
        b19.setOnClickListener(l -> addNumber("19"));
    }

    private void addNumber(String number) {
        String text = decimalNumbersText.getText().toString();
        text += number + " ";
        decimalNumbersText.setText(text);
    }

    private void calculateNumber() {
        String text = decimalNumbersText.getText().toString().trim();
        StringTokenizer tokenizer = new StringTokenizer(text, " ");
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            tokens.add(0, token);
        }
        int counter = 0;
        int result = 0;
        for (String token : tokens) {
            int numeral = Integer.parseInt(token);
            if (counter == 0) {
                result += numeral;
            } else {
                result += multiplyPosition(counter) * numeral;
            }
            counter++;
        }
        showMessage(result);
    }

    private int multiplyPosition(int counter) {
        int mult = 1;
        for (int i = 0; i < counter; i++) {
            mult *= 20;
        }
        return mult;
    }

    private void showMessage(int result) {
        if (result > 0) {
            new AlertDialog.Builder(this)
                    .setPositiveButton(getString(R.string.ok_message), null)
                    .setMessage(getString(R.string.dec_number_is) + " " + result)
                    .setTitle("Mensaje")
                    .show();
        } else {
            new AlertDialog.Builder(this)
                    .setPositiveButton(getString(R.string.ok_message), null)
                    .setMessage(getString(R.string.number_too_big))
                    .setTitle("Msg")
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.draw_numbers_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.back_menu:
                returnToMain();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void returnToMain() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        this.getApplicationContext().startActivity(intent);
    }

}

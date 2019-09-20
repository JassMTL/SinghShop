package com.example.singhshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CheckoutActivity extends AppCompatActivity {

    private TextView showSubtotal;
    private TextView showGst;
    private TextView showQst;
    private TextView showFinalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent = getIntent();
        double subtotal = intent.getDoubleExtra(MenuActivity.EXTRA_NUMBER,0);
        showTax(subtotal);
    }

    public void showTax(double subtotal) {
        showSubtotal = (TextView) findViewById(R.id.valBeforeTax);
        showGst = (TextView) findViewById(R.id.valGst);
        showQst = (TextView) findViewById(R.id.valQst);
        showFinalPrice = (TextView) findViewById(R.id.valFinal);

        double valueGst = subtotal * 0.05;
        double valueQst = subtotal * 0.0975;
        double finalPrice = subtotal + valueGst + valueQst;

        showSubtotal.setText(String.format("$%.2f",subtotal));
        showGst.setText(String.format("$%.2f",valueGst));
        showQst.setText(String.format("$%.2f",valueQst));
        showFinalPrice.setText(String.format("$%.2f",finalPrice));
    }
}

package com.example.singhshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CheckoutActivity extends AppCompatActivity {

    /**
     * variables for all the text view
     */
    private TextView showSubtotal;
    private TextView showGst;
    private TextView showQst;
    private TextView showFinalPrice;

    /**
     * it receives the information sent from menu activity and calls the method to show the taxes
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent = getIntent();
        double subtotal = intent.getDoubleExtra(MenuActivity.EXTRA_NUMBER,0);
        showTax(subtotal);
    }

    /**
     * links the text view to their respective id
     * calculates gst qst and final price
     * formats the output and sets the texts to their respective text view
     * @param subtotal
     */
    public void showTax(double subtotal) {
        showSubtotal = (TextView) findViewById(R.id.valBeforeTax);
        showGst = (TextView) findViewById(R.id.valGst);
        showQst = (TextView) findViewById(R.id.valQst);
        showFinalPrice = (TextView) findViewById(R.id.valFinal);

        double valueGst = subtotal * 0.05;
        double valueQst = subtotal * 0.09975;
        double finalPrice = subtotal + valueGst + valueQst;

        showSubtotal.setText(String.format("$%.2f",subtotal));
        showGst.setText(String.format("$%.2f",valueGst));
        showQst.setText(String.format("$%.2f",valueQst));
        showFinalPrice.setText(String.format("$%.2f",finalPrice));
    }
}

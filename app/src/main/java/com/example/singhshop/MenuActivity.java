package com.example.singhshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private final double priceKarra = 24.99;
    private final double priceKirpan = 99.99;
    private final double pricePendant = 19.99;

    private double subtotal = 0;

    private int karraCount = 0;
    private int kirpanCount = 0;
    private int pendantCount = 0;

    private TextView showKarraCount;
    private TextView showKirpanCount;
    private TextView showPendantCount;

    private TextView showKarraSubtotal;
    private TextView showKirpanSubtotal;
    private TextView showPendantSubtotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        showKarraSubtotal = (TextView) findViewById(R.id.subtotalKarra);
        showKirpanSubtotal = (TextView) findViewById(R.id.subtotalKirpan);
        showPendantSubtotal = (TextView) findViewById(R.id.subtotalPendant);

        showKarraCount = (TextView) findViewById(R.id.amountKarra);
        showKirpanCount = (TextView) findViewById(R.id.amountKirpan);
        showPendantCount = (TextView) findViewById(R.id.amountPendant);

    }

    public void increaseKarra(View view){
        ++karraCount;
        showKarraCount.setText(Integer.toString(karraCount));
        subtotal +=priceKarra;
    }

    public void decreaseKarra(View view){
        if(karraCount != 0) {
            --karraCount;
            showKarraCount.setText(Integer.toString(karraCount));
            subtotal -=priceKarra;
        }
    }

    public void increaseKirpan(View view){
        ++kirpanCount;
        showKirpanCount.setText(Integer.toString(kirpanCount));
        subtotal += priceKirpan;
    }

    public void decreaseKirpan(View view){
        if(kirpanCount != 0) {
            --kirpanCount;
            showKirpanCount.setText(Integer.toString(kirpanCount));
            subtotal -= priceKirpan;
        }
    }

    public void increasePendant(View view){
        ++pendantCount;
        showPendantCount.setText(Integer.toString(pendantCount));
        subtotal += pricePendant;
    }

    public void decreasePendant(View view){
        if(pendantCount != 0) {
            --pendantCount;
            showPendantCount.setText(Integer.toString(pendantCount));
            subtotal -= pricePendant;
        }
    }

    public void checkout(View view) {
        Intent intent = new Intent(this, CheckoutActivity.class);
        startActivity(intent);
    }
}

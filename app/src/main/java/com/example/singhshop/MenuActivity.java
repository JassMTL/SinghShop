/**
 * Jaspreet Singh
 * Assgnment 1
 * Due : September 20th
 */
package com.example.singhshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    /**
     * This part contains all the major variables used in the program
     * including the price of the products, the subtotal, the count and the text views
     */
    public static final String EXTRA_NUMBER = "com.example.singhshop.EXTRA_NUMBER";
    private final double priceKarra = 25;
    private final double priceKirpan = 100;
    private final double pricePendant = 20;

    private double total = 0;
    private double subtotalKarra = 0;
    private double subtotalKirpan = 0;
    private double subtotalPendant = 0;

    private int karraCount = 0;
    private int kirpanCount = 0;
    private int pendantCount = 0;

    private TextView showKarraCount;
    private TextView showKirpanCount;
    private TextView showPendantCount;

    private TextView showTotal;
    private TextView showKarraSubtotal;
    private TextView showKirpanSubtotal;
    private TextView showPendantSubtotal;


    @Override
    /**
     * it creates the application and links the texviews to their positions
     *
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        showTotal = (TextView) findViewById(R.id.totalAll);
        showKarraSubtotal = (TextView) findViewById(R.id.subtotalKarra);
        showKirpanSubtotal = (TextView) findViewById(R.id.subtotalKirpan);
        showPendantSubtotal = (TextView) findViewById(R.id.subtotalPendant);

        showKarraCount = (TextView) findViewById(R.id.amountKarra);
        showKirpanCount = (TextView) findViewById(R.id.amountKirpan);
        showPendantCount = (TextView) findViewById(R.id.amountPendant);

    }

    /**
     * @param view
     * when the increase button is clicked, the count var and view, the grand total, the grand total,
     * and the views to show the subtotal and grand total are increased by a correct amount
     */
    public void increaseKarra(View view){
        ++karraCount;
        showKarraCount.setText(Integer.toString(karraCount));
        total +=priceKarra;
        subtotalKarra += priceKarra;
        showKarraSubtotal.setText(Double.toString(subtotalKarra));
        showTotal.setText(Double.toString(total));
    }

    /**
     * @param view
     * when the decreased button is clicked, the count var and view, the grand total, the grand total,
     * and the views to show the subtotal and grand total are decreased by a correct amount
     */
    public void decreaseKarra(View view){
        if(karraCount != 0) {
            --karraCount;
            showKarraCount.setText(Integer.toString(karraCount));
            total -=priceKarra;
            subtotalKarra -= priceKarra;

            showKarraSubtotal.setText(Double.toString(subtotalKarra));
            showTotal.setText(Double.toString(total));
        }
    }

    /**
     * @param view
     * when the increase button is clicked, the count var and view, the grand total, the grand total,
     * and the views to show the subtotal and grand total are increased by a correct amount
     */
    public void increaseKirpan(View view){
        ++kirpanCount;
        showKirpanCount.setText(Integer.toString(kirpanCount));
        total += priceKirpan;
        subtotalKirpan += priceKirpan;

        showKirpanSubtotal.setText(Double.toString(subtotalKirpan));
        showTotal.setText(Double.toString(total));
    }

    /**
     * @param view
     * when the decreased button is clicked, the count var and view, the grand total, the grand total,
     * and the views to show the subtotal and grand total are decreased by a correct amount
     */
    public void decreaseKirpan(View view){
        if(kirpanCount != 0) {
            --kirpanCount;
            showKirpanCount.setText(Integer.toString(kirpanCount));
            total -= priceKirpan;
            subtotalKirpan -= priceKirpan;
            showKirpanSubtotal.setText(Double.toString(subtotalKirpan));
            showTotal.setText(Double.toString(total));
        }
    }

    /**
     * @param view
     * when the increase button is clicked, the count var and view, the grand total, the grand total,
     * and the views to show the subtotal and grand total are increased by a correct amount
     */
    public void increasePendant(View view){
        ++pendantCount;
        showPendantCount.setText(Integer.toString(pendantCount));

        total += pricePendant;
        subtotalPendant += pricePendant;

        showPendantSubtotal.setText(Double.toString(subtotalPendant));
        showTotal.setText(Double.toString(total));

    }

    /**
     * @param view
     * when the decreased button is clicked, the count var and view, the grand total, the grand total,
     * and the views to show the subtotal and grand total are decreased by a correct amount
     */
    public void decreasePendant(View view){
        if(pendantCount != 0) {
            --pendantCount;
            showPendantCount.setText(Integer.toString(pendantCount));

            total -= pricePendant;
            subtotalPendant -= pricePendant;

            showPendantSubtotal.setText(Double.toString(subtotalPendant));
            showTotal.setText(Double.toString(total));
        }
    }

    /**
     * @param view
     * sends the grand total to the checkout activity
     */
    public void checkout(View view) {
        Intent intent = new Intent(this, CheckoutActivity.class);

        intent.putExtra(EXTRA_NUMBER,total);
        startActivity(intent);
    }
}

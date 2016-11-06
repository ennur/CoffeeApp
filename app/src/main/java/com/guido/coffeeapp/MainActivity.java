package com.guido.coffeeapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.guido.coffeeapp.justjava.R;

public class MainActivity extends ActionBarActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean hasWhippedCream() {
        CheckBox checked = (CheckBox) findViewById(R.id.whippedCreamBox);
        return checked.isChecked();
    }

    private boolean hasChocolate() {
        CheckBox checked = (CheckBox) findViewById(R.id.chocolateBox);
        return checked.isChecked();
    }

    private String custName() {
        EditText nameBox = (EditText) findViewById(R.id.nameBox);
        return nameBox.getText().toString();
    }

    public void increment(View view) {
        if (quantity < 100) {
            quantity = quantity + 1;
            displayQuantity(quantity);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "No more than 100 coffees";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
    }

    public void decrement(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Must Order at least 1 coffee";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
    }

    public void submitOrder(View view) {
        int price = calculatePrice();
        displayMessage(createOrderSummary(price));

    }
    private int calculatePrice() {
        int price = 5;
        if (hasWhippedCream()){
            price =price + 1;
        }
        if (hasChocolate()){
            price =price + 2;
        }
        return quantity * price;
    }


    private void displayQuantity(int amount) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + amount);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private String createOrderSummary(int total) {
        String priceMessage ="Name: "+custName() + "\nAdd Whipped Cream? "
                + hasWhippedCream() + "\nAdd Chocolate? "
                + hasChocolate() + "\nQuantity: " + quantity
                + "\nTotal: $" + (total);
        priceMessage=priceMessage + "\nThank You!";
        return priceMessage;
    }

}
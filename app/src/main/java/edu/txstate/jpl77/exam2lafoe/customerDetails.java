package edu.txstate.jpl77.exam2lafoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class customerDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        TextView fName = findViewById(R.id.txtFname);
        TextView lName = findViewById(R.id.txtLname);
        TextView cost = findViewById(R.id.txtPrice);
        TextView numberOfMonths = findViewById(R.id.txtInputNoMonth);
        TextView totalCost = findViewById(R.id.txtList);
        //final EditText numberOfMonths = findViewById(R.id.txtInputNoMonth);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(customerDetailsActivity.this);

        customer selectedCustomer = new customer(
                pref.getString("KeyFirstName", null),
                pref.getString("KeyLastName", null),
                pref.getInt("KeyCost", 0),
                pref.getInt("KeyNumberOfMonths", 0);


        int totalCost = selectedCustomer.txtInputNoMonth() * selectedCustomer.monthlyFee();

        DecimalFormat f = new DecimalFormat("###,###.##");

        fName.setText("Title: " + selectedCustomer.getFirstName());
        lName.setText("Author: " + selectedCustomer.getLastName());
        cost.setText("Price: $" + f.format(selectedCustomer.getAge()));
        numberOfMonths.setText(("Number of Months" + f.format(selectedCustomer.toString())));

    }
}
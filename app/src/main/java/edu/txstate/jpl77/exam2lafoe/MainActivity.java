package edu.txstate.jpl77.exam2lafoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    List<customer> customerList = new ArrayList<customer>();

    protected void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        customer selectedCustomer = customerList.get(position);

        if (selectedCustomer.getAge() <= 18){
            Toast.makeText(MainActivity.this, "This can't sign a service contract!", Toast.LENGTH_LONG).show();
        }

        else{
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
            SharedPreferences.Editor editor = pref.edit();
            editor.putInt("KeyID", selectedCustomer.getId());
            editor.putString("KeyFirstName", selectedCustomer.getFirstName());
            editor.putString("KeyLastName", selectedCustomer.getLastName());
            editor.putInt("KeyAge", selectedCustomer.getAge());

            editor.commit();

            startActivity(new Intent(MainActivity.this, customerDetailsActivity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        customer customer1 = new customer(1,"Jordan", "LaFoe", 32);
        customer customer2 = new customer(2, "Rico", "Suave", 25);
        customer customer3 = new customer(3, "Jerry", "Rice", 20);
        customer customer4 = new customer(4, "Patrick", "Mahomes", 33);
        customer customer5 = new customer(5, "Leo", "DiVinci", 56);

        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        customerList.add(customer5);

        setListAdapter(new ArrayAdapter<customer>(MainActivity.this, R.layout.activity_main, R.id.txtList, customerList));

    }
}
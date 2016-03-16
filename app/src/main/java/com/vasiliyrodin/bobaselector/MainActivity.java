package com.vasiliyrodin.bobaselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import java.util.Random;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String[] bobaPlaces;
    String selectedBobaPlace;
    String[] superQueTea = {"Assam Tea", "Toffee Tea", "Earl Grey Tea", "High Mountain Oolong Tea", "Peach Oolong Tea", "Dark Roast Oolong Tea", "Jasmine Tea", "Osmanthus Tea", "Hojicha Tea", "Rose Tea", "Ceylon Tea", "Lychee Tea", "White Grape Oolong Tea", "Matcha Green Tea Latte"};
    String[] superQueBoba = {"Boba", "Grass Jelly", "Mango Pudding", "Aloe Vera", "Red Bean", "Rainbow Jelly", "Coffee Jelly", "Lychee Jelly", "Fresh Taro", "Crystal Boba"};
    String[] t4Tea = {"Earl Grey Milk Tea", "Jasmine Green Tea", "Roasted Oolong Milk Tea", "Royal Fresh Milk Tea", "Classic Rose Milk Tea", "Red Bean Milk Tea", "Peppermint Milk Tea", "Honey Peach Royal Tea", "Jadeite Royal Tea", "Passion Fruit Royal Tea", "Grapefruit Royal Tea", "Mango Royal Tea"};
    String[] t4Boba = {"Pearl", "Aloe", "Coconut Jelly", "Rainbow Jelly", "Coffee Jelly", "Grass Jelly", "Fig Jelly", "Pudding", "Red Bean"};
    String[] teaStationTea = {"Black Tea", "Green Tea", "Mango Black Tea", "Passion Fruit Black Tea", "Passion Fruit Green Tea", "Peach Black Tea", "Peach Green Tea", "Rose Black Tea", "Rose Green Tea", "Plum Black Tea", "Plum Green Tea", "Royal Black Tea", "Barley Black Tea", "Lychee Green Tea", "Yogurt Green Tea"};
    String[] teaStationBoba = {"Boba", "Boba Noodles", "Three Color Jelly", "Lychee Jelly", "Mocha Jelly", "Aloe Vera", "Egg Pudding", "Grass Jelly", "Crystal Jelly", "Red Bean", "Green Bean", "Mixed Jello", "Sweet Potato Balls", "Taro Balls", "Rice Balls"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creates the spinner with the names of boba places.
        bobaPlaces = getResources().getStringArray(R.array.bobaPlace_array);
        Spinner s1 = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bobaPlaces);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();
                //Need to get info from here to makemeBoba for the correct boba selection.
                Toast.makeText(getBaseContext(), "You have selected: " + bobaPlaces[index], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    public void makeMeBoba(View view) {
        String randomDrink = null;
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        String text = mySpinner.getSelectedItem().toString();

        if (text.equals("Super Que")) {
            randomDrink = selectRandomBoba(superQueTea, superQueBoba);
        } else if (text.equals("Tea Station")) {
            randomDrink = selectRandomBoba(teaStationTea, teaStationBoba);
        } else if (text.equals("T4")) {
            randomDrink = selectRandomBoba(t4Tea, t4Boba);
        }
        // send result of randomBoba as intent to next Screen.
        Intent i = new Intent("com.vasiliyrodin.PassingDataSecondActivity");
        i.putExtra("boba", randomDrink);
        startActivity(i);
    }

    /*
    Creates the correct drink using the correct info.
     */
    public String selectRandomBoba(String[] tea, String[] boba) {
        String[] teaFlavor = tea;
        String[] toppings = boba;
        int teaFlavorLength = teaFlavor.length;
        int toppingsLength = toppings.length;

        Random random = new Random();
        String drink = teaFlavor[random.nextInt(teaFlavorLength)] + " with " + toppings[random.nextInt(toppingsLength)];
        return drink;
    }
}

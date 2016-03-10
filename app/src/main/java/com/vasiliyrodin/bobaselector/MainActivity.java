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
    String[] superQueTea = {"Assam", "Toffee", "Earl Grey", "High Mountain Oolong","Peach Oolong", "Dark Roast Oolong", "Jasmine","Osmanthus", "Hojicha", "Rose" , "Ceylon", "Lychee", "White Grape Oolong", "Matcha Green Tea Latte"};
    String[] superQueBoba = {"Boba", "Grass Jelly", "Mango Pudding", "Aloe Vera", "Red Bean", "Rainbow Jelly", "Coffee Jelly", "Lychee Jelly", "Fresh Taro","Crystal Boba"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creates the spinner with the names of boba places.
        bobaPlaces = getResources().getStringArray(R.array.bobaPlace_array);
        Spinner s1 = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, bobaPlaces);

        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();
                selectCorrectStore(bobaPlaces[index]);
                Toast.makeText(getBaseContext(),"You have selected: " + bobaPlaces[index], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {}
        });
    }

    public String selectCorrectStore(String store){
        String drink;
        String chosenStore = store;
        if (chosenStore == "Super Que") {
            // Run makeMeBoba with the superQue menu
            drink = selectRandomBoba(superQueTea,superQueBoba);
        } else if(chosenStore == "T4"){
            // RUn make me bob with the T4 menu
            drink = selectRandomBoba(t4Tea,t4Boba);
        }
        else if(chosenStore == "Tea Station"){
            //Run makeMeBoba with Tea Station menu
            drink = selectRandomBoba(teaStationTea,teaStationBoba);
        };
        return drink;
    }


    public void makeMeBoba(View view){
        String randomDrink = selectRandomBoba();
        // send result of randomBoba as intent to next Screen.

        Intent i = new Intent("com.vasiliyrodin.PassingDataSecondActivity");
        i.putExtra("boba", randomDrink);
        startActivity(i);
    }

    public String selectRandomBoba(String[] tea, String[] boba){
        String[] teaFlavor = tea;
        String[] toppings = boba;
        int teaFlavorLength = teaFlavor.length;
        int toppingsLength  = toppings.length;

        Random random = new Random();
        String drink = teaFlavor[random.nextInt(teaFlavorLength)] + " with " + toppings[random.nextInt(toppingsLength)];
        return drink;
    }
}

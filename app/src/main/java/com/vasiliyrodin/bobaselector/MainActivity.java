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
    String[] t4Tea = {"A","B","C"};
    String[] t4Boba = {"a","b","c"};
    String[] teaStationTea = {"1","2","3"};
    String[] teaStationBoba = {"4","5","6"};

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
                //Need to get info from here to makemeBoba for the correct boba selection.
                Toast.makeText(getBaseContext(),"You have selected: " + bobaPlaces[index], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {}
        });
    }

    public void makeMeBoba(View view){
        String randomDrink = selectRandomBoba(superQueTea, superQueBoba);
        // send result of randomBoba as intent to next Screen.

        Intent i = new Intent("com.vasiliyrodin.PassingDataSecondActivity");
        i.putExtra("boba", randomDrink);
        startActivity(i);
    }
    /*
    Creates the correct drink using the correct info.
     */
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

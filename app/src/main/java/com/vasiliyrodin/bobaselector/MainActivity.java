package com.vasiliyrodin.bobaselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makeMeBoba(View view){
        String randomDrink = selectRandomBoba();
        // send result of randomBoba as intent to next Screen.

        Intent i = new Intent("com.vasiliyrodin.PassingDataSecondActivity");
        i.putExtra("boba", randomDrink);
        startActivity(i);
    }

    public String selectRandomBoba(){
        String[] teaFlavor = {"Assam", "Toffee", "Earl Grey", "High Mountain Oolong","Peach Oolong", "Dark Roast Oolong", "Jasmine","Osmanthus", "Hojicha", "Rose" , "Ceylon", "Lychee", "White Grape Oolong", "Matcha Green Tea Latte"};
        String[] toppings = {"1", "2", "3", "4", "5", "6", "7", "8", "9" };

        int teaFlavorLength = teaFlavor.length;
        int toppingsLength  = toppings.length;


        Random random = new Random();
        String drink = teaFlavor[random.nextInt(teaFlavorLength)] + " with " + toppings[random.nextInt(toppingsLength)];
        return drink;
    }
}

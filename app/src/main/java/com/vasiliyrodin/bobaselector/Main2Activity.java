package com.vasiliyrodin.bobaselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    TextView bobaTextView = (TextView)findViewById(R.id.bobaView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String generatedBoba = intent.getExtras().getString("boba");
        bobaTextView.setText(generatedBoba);
    }



}

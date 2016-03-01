package com.vasiliyrodin.bobaselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    TextView bobaTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bobaTextView = (TextView) findViewById(R.id.bobaView);
        Intent intent = getIntent();
        String generatedBoba = intent.getExtras().getString("boba");
        bobaTextView.setText(generatedBoba);
    }

    public void backButtonClick(View view){
        finish();
    }
}

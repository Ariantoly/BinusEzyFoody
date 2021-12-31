package com.ariantoly.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToDrinks(View view) {
        startActivity(new Intent(MainActivity.this, DrinksActivity.class));
    }

    public void goToMyOrder(View view) {
        startActivity(new Intent(MainActivity.this, MyOrderActivity.class));
    }
}
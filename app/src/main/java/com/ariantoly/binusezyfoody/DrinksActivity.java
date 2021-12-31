package com.ariantoly.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class DrinksActivity extends AppCompatActivity {

    public ArrayList<Drink> drinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        initialize();

        RecyclerView rv_drinks = findViewById(R.id.rv_drinks);
        DrinkAdapter adapter = new DrinkAdapter(drinks);
        rv_drinks.setAdapter(adapter);
        rv_drinks.setLayoutManager(new GridLayoutManager(this, 2));

    }

    public void initialize() {
        drinks = new ArrayList<>();
        Drink drink1 = new Drink(1, "Air Mineral", 3000, R.drawable.air_mineral);
        Drink drink2 = new Drink(2, "Jus Apel Hijau", 7000, R.drawable.jus_apel_hijau);
        Drink drink3 = new Drink(3, "Jus Mangga", 7000, R.drawable.jus_mangga);
        Drink drink4 = new Drink(4, "Jus Alpukat", 8000, R.drawable.jus_alpukat);
        Drink drink5 = new Drink(5, "Jus Jeruk", 7000, R.drawable.jus_jeruk);
        Drink drink6 = new Drink(6, "Kopi Latte", 5000, R.drawable.kopi_latte);
        Drink drink7 = new Drink(7, "Es Teh Manis", 3000, R.drawable.es_teh);
        Drink drink8 = new Drink(8, "Teh Manis Hangat", 3000, R.drawable.teh_panas);

        drinks.add(drink1);
        drinks.add(drink2);
        drinks.add(drink3);
        drinks.add(drink4);
        drinks.add(drink5);
        drinks.add(drink6);
        drinks.add(drink7);
        drinks.add(drink8);

    }

    public void goToMyOrder(View view) {
        startActivity(new Intent(DrinksActivity.this, MyOrderActivity.class));
    }
}
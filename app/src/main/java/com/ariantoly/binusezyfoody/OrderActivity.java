package com.ariantoly.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    public ImageView img_drink;
    public TextView tv_drink_name;
    public TextView tv_drink_price;
    public TextView tv_drink_qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Cart cart = (Cart) getIntent().getSerializableExtra("cart");

        img_drink = findViewById(R.id.img_drink);
        img_drink.setImageResource(cart.getDrink().getImage());

        tv_drink_name = findViewById(R.id.tv_drink_name);
        tv_drink_name.setText(cart.getDrink().getDrinkName());

        tv_drink_price = findViewById(R.id.tv_drink_price);
        tv_drink_price.setText("Rp " + cart.getDrink().getDrinkPrice());

        tv_drink_qty = findViewById(R.id.tv_drink_qty);
        tv_drink_qty.setText("Quantity: " + cart.getQty());


    }

    public void goToMyOrder(View view) {
        startActivity(new Intent(OrderActivity.this, MyOrderActivity.class));
    }

    public void orderMore(View view) {
        finish();
    }
}
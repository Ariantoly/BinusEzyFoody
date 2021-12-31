package com.ariantoly.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderCompleteActivity extends AppCompatActivity {

    public TextView tv_total;
    public int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        tv_total = findViewById(R.id.tv_total);

        RecyclerView rv_cart = findViewById(R.id.rv_order_complete);
        MyOrderAdapter adapter = new MyOrderAdapter(MyOrderActivity.CARTS, R.layout.item_order_complete_recycler_view);
        rv_cart.setAdapter(adapter);
        rv_cart.setLayoutManager(new LinearLayoutManager(this));

        calculate();

    }

    public void calculate() {
        total = 0;
        for (Cart c : MyOrderActivity.CARTS) {
            total += c.getQty() * c.getDrink().getDrinkPrice();
        }

        tv_total.setText("Total: Rp " + total);
    }

    public void goToMain(View view) {
        MyOrderActivity.CARTS.clear();
        startActivity(new Intent(OrderCompleteActivity.this, MainActivity.class));
        finish();
    }
}
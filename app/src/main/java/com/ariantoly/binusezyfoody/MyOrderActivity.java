package com.ariantoly.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {

    public static ArrayList<Cart> CARTS = new ArrayList<>();
    public int total = 0;
    public TextView tv_total;
    public Button btn_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        RecyclerView rv_cart = findViewById(R.id.rv_my_order);
        MyOrderAdapter adapter = new MyOrderAdapter(CARTS, R.layout.item_my_order_recycler_view);
        rv_cart.setAdapter(adapter);
        rv_cart.setLayoutManager(new LinearLayoutManager(this));

        tv_total = findViewById(R.id.tv_total);

        rv_cart.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                calculate();
            }
        });

    }

    public void calculate() {
        if(CARTS.isEmpty()) {
            tv_total.setText("No order");
            btn_pay = findViewById(R.id.btn_pay);
            btn_pay.setEnabled(false);
            btn_pay.setBackground(getResources().getDrawable(R.drawable.button_disabled_background));
            btn_pay.setTextColor(getResources().getColor(R.color.white));
        }
        else {
            total = 0;
            for (Cart c : CARTS) {
                total += c.getQty() * c.getDrink().getDrinkPrice();
            }

            tv_total.setText("Total: Rp " + total);
        }
    }

    public void payNow(View view) {
        startActivity(new Intent(MyOrderActivity.this, OrderCompleteActivity.class));
        finish();
    }
}
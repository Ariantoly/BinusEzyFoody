package com.ariantoly.binusezyfoody;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.ViewHolder> {

    public ArrayList<Drink> drinks;

    public DrinkAdapter(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }

    @NonNull
    @Override
    public DrinkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View viewDrink = layoutInflater.inflate(R.layout.item_drinks_recyler_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(viewDrink);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkAdapter.ViewHolder holder, int position) {
        Drink drink = drinks.get(position);

        ImageView img_drink = holder.img_drink;
        img_drink.setImageResource(drink.getImage());

        TextView tv_drink_name = holder.tv_drink_name;
        tv_drink_name.setText(drink.getDrinkName());

        TextView tv_drink_price = holder.tv_drink_price;
        tv_drink_price.setText("Rp " + drink.getDrinkPrice());

        LinearLayout ll_drink = holder.ll_drink;
        ll_drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Quantity");
                View view = LayoutInflater.from(v.getContext()).inflate(R.layout.input_dialog, (ViewGroup) v, false);
                EditText tv_quantity = (EditText) view.findViewById(R.id.tv_quantity);
                builder.setView(view);

                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!tv_quantity.getText().toString().trim().equals("")) {
                            dialog.dismiss();
                            int qty = Integer.parseInt(tv_quantity.getText().toString());
                            Cart cart = new Cart(drink, qty);
                            MyOrderActivity.CARTS.add(cart);
                            Intent intent = new Intent(v.getContext(), OrderActivity.class);
                            intent.putExtra("cart", cart);
                            v.getContext().startActivity(intent);
                        }
                    }
                });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout ll_drink;
        public ImageView img_drink;
        public TextView tv_drink_name;
        public TextView tv_drink_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_drink = itemView.findViewById(R.id.ll_drink);
            img_drink = itemView.findViewById(R.id.img_drink);
            tv_drink_name = itemView.findViewById(R.id.tv_drink_name);
            tv_drink_price = itemView.findViewById(R.id.tv_drink_price);
        }
    }
}

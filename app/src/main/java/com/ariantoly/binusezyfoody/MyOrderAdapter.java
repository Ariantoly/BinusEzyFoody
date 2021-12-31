package com.ariantoly.binusezyfoody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {

    public ArrayList<Cart> carts;
    public int layout;

    public MyOrderAdapter(ArrayList<Cart> carts, int layout) {
        this.carts = carts;
        this.layout = layout;
    }

    @NonNull
    @Override
    public MyOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View viewDrink = layoutInflater.inflate(layout, parent, false);
        MyOrderAdapter.ViewHolder viewHolder = new MyOrderAdapter.ViewHolder(viewDrink);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.ViewHolder holder, int position) {
        Cart cart = carts.get(position);
        int pos = position;

        ImageView img_drink = holder.img_drink;
        img_drink.setImageResource(cart.getDrink().getImage());

        TextView tv_drink_name = holder.tv_drink_name;
        tv_drink_name.setText(cart.getDrink().getDrinkName());

        TextView tv_drink_price_detail = holder.tv_drink_price_detail;
        int qty = cart.getQty();
        int price = cart.getDrink().getDrinkPrice();
        tv_drink_price_detail.setText(qty + " x Rp " + price);

        TextView tv_drink_total = holder.tv_drink_total;
        tv_drink_total.setText("Rp " + (qty * price));

        if(layout == R.layout.item_my_order_recycler_view) {
            Button btn_hapus = holder.btn_hapus;
            btn_hapus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyOrderActivity.CARTS.remove(cart);
                    carts.remove(cart);
                    notifyItemRemoved(pos);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView img_drink;
        public TextView tv_drink_name;
        public TextView tv_drink_price_detail;
        public TextView tv_drink_total;
        public Button btn_hapus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_drink = itemView.findViewById(R.id.img_drink);
            tv_drink_name = itemView.findViewById(R.id.tv_drink_name);
            tv_drink_price_detail = itemView.findViewById(R.id.tv_drink_price_detail);
            tv_drink_total = itemView.findViewById(R.id.tv_drink_total);
            if(layout == R.layout.item_my_order_recycler_view)
                btn_hapus = itemView.findViewById(R.id.btn_hapus);
        }
    }
}

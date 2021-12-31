package com.ariantoly.binusezyfoody;

import java.io.Serializable;

public class Cart implements Serializable {
    private Drink drink;
    private int qty;

    public Cart(Drink drink, int qty) {
        this.drink = drink;
        this.qty = qty;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

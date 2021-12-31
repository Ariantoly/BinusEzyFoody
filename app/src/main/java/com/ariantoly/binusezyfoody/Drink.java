package com.ariantoly.binusezyfoody;

import java.io.Serializable;

public class Drink implements Serializable {
    private int id;
    private String drinkName;
    private int drinkPrice;
    private int image;

    public Drink(int id, String drinkName, int drinkPrice, int image) {
        this.id = id;
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public int getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(int drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

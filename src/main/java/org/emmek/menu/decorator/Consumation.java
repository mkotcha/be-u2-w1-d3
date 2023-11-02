package org.emmek.menu.decorator;

import lombok.Getter;


@Getter
public abstract class Consumation {

    String productName = "";
    String ingredients = "";
    double price;
    boolean isXl;

    @Override
    public String toString() {
        return getProductName() + " ( " + getIngredients() + " ) " + " - " + getPrice() + " €";
    }

}

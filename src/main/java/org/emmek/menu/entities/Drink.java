package org.emmek.menu.entities;

import lombok.Getter;

public class Drink {
    String productName;
    double capacity;
    @Getter
    double price;

    public Drink(String productName, double capacity, double price) {
        this.productName = productName;
        this.capacity = capacity;
        this.price = price;
    }

    @Override
    public String toString() {
        return productName + " ( " + capacity + " ) " +
                " - " + String.format("%.2f", price) + "€\n";
    }

}

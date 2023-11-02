package org.emmek.menu.entities;

public class AlcoholicDrink extends Drink {

    double volume;

    public AlcoholicDrink(String productName, double capacity, double price, double volume) {
        super(productName, capacity, price);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return productName + " ( " + capacity + ", " + volume + "% ) " +
                " - " + String.format("%.2f", price) + "€";
    }
}

package org.emmek.menu.decorator;

public class PizzaMargheritaXl extends Consumation {
    public PizzaMargheritaXl() {
        productName = "Pizza Margherita XL";
        ingredients = "pomodoro, mozzarella";
        isXl = true;
    }

    @Override
    public double getPrice() {
        return 8.0;
    }
}

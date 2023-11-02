package org.emmek.menu.decorator;

import org.springframework.stereotype.Component;

@Component
public class PizzaMargherita extends Consumation {

    public PizzaMargherita() {
        productName = "Pizza Margherita";
        ingredients = "pomodoro, mozzarella";
        price = 5.0;
    }
}

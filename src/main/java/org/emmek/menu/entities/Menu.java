package org.emmek.menu.entities;

import lombok.Getter;
import lombok.Setter;
import org.emmek.menu.decorator.Consumation;
import org.emmek.menu.decorator.ExtraAddictionDecorator;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Menu {
    public List<Consumation> pizzas = new ArrayList<>();
    public List<Drink> drinks = new ArrayList<>();
    public List<ExtraAddictionDecorator> toppings = new ArrayList<>();

    public Menu(List<Consumation> pizzas, List<Drink> drinks, List<ExtraAddictionDecorator> toppings) {
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.toppings = toppings;
    }

    public void addPizza(Consumation pizza) {
        System.out.println("\n error\n" + pizza.toString());
        pizzas.add(pizza);
    }

    public void addDrink(Drink drink) {
        List<Drink> drinksTmp = drinks;
        drinksTmp.add(drink);
        this.drinks = drinksTmp;
    }

    public void printMenu() {

        System.out.println("\nSpring Beans Pizza Menu:\n");
        System.out.println("\n pizzas:\n");
        pizzas.forEach(System.out::println);

        System.out.println("\n toppings:\n");
        toppings.forEach(ExtraAddictionDecorator::singlePrint);

        System.out.println("\n drinks:\n");
        drinks.forEach(System.out::println);
    }

    public double getPrice() {
        double totalPrice = 0;
        for (Consumation pizza : pizzas) {
            totalPrice += pizza.getPrice();
        }
        for (Drink drink : drinks) {
            totalPrice += drink.getPrice();
        }
        return totalPrice;
    }
}

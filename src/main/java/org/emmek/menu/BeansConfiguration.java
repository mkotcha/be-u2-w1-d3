package org.emmek.menu;

import org.emmek.menu.decorator.*;
import org.emmek.menu.entities.AlcoholicDrink;
import org.emmek.menu.entities.Drink;
import org.emmek.menu.entities.Menu;
import org.emmek.menu.entities.Table;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Random;

@Configuration
public class BeansConfiguration {

    private static int tableNumber = 1;

    @Bean
    public Consumation getPizzaXl() {
        return new PizzaMargheritaXl();
    }

    @Bean
    Table getTable() {
        Random random = new Random();
        return new Table(tableNumber++, random.nextInt(10) + 2);
    }

    @Bean
    Drink getWater() {
        return new Drink("water", 0.5, 1);
    }

    @Bean
    Drink getCocaCola() {
        return new Drink("Coca Cola", 0.33, 2.5);
    }

    @Bean
    Drink getBeer() {
        return new AlcoholicDrink("beer", 0.33, 3, 4.5);
    }

    @Bean
    @Primary
    Menu getMenu() {

        Consumation pizza = new PizzaMargherita();

        Consumation pizzaSalami = new PizzaMargherita();
        pizzaSalami = new ExtraSalameDecorator(pizzaSalami);

        Consumation pizzaHawaii = new PizzaMargherita();
        pizzaHawaii = new ExtraAnanasDecorator(pizzaHawaii);
        pizzaHawaii = new ExtraProsciuttoDecorator(pizzaHawaii);
//        pizzaHawaii = new ExtraProsciuttoDecorator(pizzaHawaii);

        Consumation pizzaXl = new ExtraSalameDecorator(getPizzaXl());
        pizzaXl = new ExtraProsciuttoDecorator(pizzaXl);
        pizzaXl = new ExtraAnanasDecorator(pizzaXl);


        List<Consumation> pizzas = List.of(pizza, pizzaHawaii, pizzaSalami, pizzaXl);
        List<Drink> drinks = List.of(new Drink("Coca Cola", 0.33, 2.5),
                new Drink("wather", 0.5, 1),
                new AlcoholicDrink("beer", 0.33, 3, 4.5));
        List<ExtraAddictionDecorator> toppings = List.of(new ExtraSalameDecorator(pizza), new ExtraAnanasDecorator(pizza), new ExtraProsciuttoDecorator(pizza));

        return new Menu(pizzas, drinks, toppings);
    }
}

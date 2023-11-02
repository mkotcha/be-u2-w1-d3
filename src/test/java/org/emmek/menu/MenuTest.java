package org.emmek.menu;


import org.emmek.menu.decorator.Consumation;
import org.emmek.menu.decorator.ExtraAddictionDecorator;
import org.emmek.menu.entities.Drink;
import org.emmek.menu.entities.Menu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MenuTest {

    private static AnnotationConfigApplicationContext ctx;
    private Menu menu;


    @BeforeAll
    static void beforeAll() {
        ctx = new AnnotationConfigApplicationContext(MenuApplication.class);
    }

    @BeforeEach
    void beforeEach() {
        List<Drink> drinks = new ArrayList<>();
        List<Consumation> pizzas = new ArrayList<>();
        List<ExtraAddictionDecorator> toppings = new ArrayList<>();
        menu = new Menu(pizzas, drinks, toppings);
    }

    @Test
    void tesEmptyMenuGetPrice() {
        double price = menu.getPrice();
        assertEquals(0, price);
    }

    @Test
    void tesDrinkMenuGetPrice() {
        Drink water = ctx.getBean("getWater", Drink.class);
        Drink beer = ctx.getBean("getBeer", Drink.class);
        menu.addDrink(water);
        menu.addDrink(beer);
        double price = menu.getPrice();
        assertEquals(4, price);
    }
}

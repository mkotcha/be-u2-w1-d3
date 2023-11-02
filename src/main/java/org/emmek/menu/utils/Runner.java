package org.emmek.menu.utils;

import org.emmek.menu.MenuApplication;
import org.emmek.menu.decorator.*;
import org.emmek.menu.entities.Drink;
import org.emmek.menu.entities.Menu;
import org.emmek.menu.entities.Order;
import org.emmek.menu.entities.Table;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MenuApplication.class);
//        Menu menu = context.getBean(Menu.class);

        Menu menu = context.getBean(Menu.class);
        menu.printMenu();

        Consumation pizza1 = context.getBean(ExtraSalameDecorator.class);
        Consumation pizza4 = context.getBean(PizzaMargherita.class);
        Consumation pizza5 = context.getBean(PizzaMargherita.class);

        List<Consumation> pizzas = new ArrayList<>();
        List<ExtraAddictionDecorator> toppings = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();

        pizzas.add(pizza4);
        pizzas.add(pizza5);
        drinks.add(context.getBean("getWater", Drink.class));
        drinks.add(context.getBean("getBeer", Drink.class));

        Menu menu2 = new Menu(pizzas, drinks, toppings);

        fakeOrder(menu2);
        menu2.addPizza(pizza1);
        menu2.addDrink(context.getBean("getBeer", Drink.class));
        fakeOrder(menu2);
    }


    public void fakeOrder(Menu menu) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MenuApplication.class);
        Order order = context.getBean(Order.class);
        order.setTable(context.getBean("getTable", Table.class));
        order.setMenu(menu);
        order.printOrder();
    }

    public void old() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MenuApplication.class);
//        Menu menu = context.getBean(Menu.class);


        Consumation pizza = context.getBean(PizzaMargherita.class);
//        Consumation pizza2 = context.getBean(PizzaMargherita.class);
        Consumation pizza3 = context.getBean(PizzaMargherita.class);
        Consumation pizza2 = context.getBean(ExtraAnanasDecorator.class);
        pizza2 = new ExtraProsciuttoDecorator(pizza2);
        pizza3 = context.getBean(ExtraSalameDecorator.class);
//        pizza2 = new ExtraProsciuttoDecorator(pizza2);
//        menu.addPizza(pizza2);

        Menu menu = new Menu(List.of(pizza, pizza2, pizza3),
                List.of(),
                List.of(context.getBean(ExtraSalameDecorator.class),
                        context.getBean(ExtraProsciuttoDecorator.class),
                        context.getBean(ExtraAnanasDecorator.class)));
        menu.printMenu();
    }
}

package org.emmek.menu;

import lombok.extern.slf4j.Slf4j;
import org.emmek.menu.decorator.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
public class DecoratorTest {
    static Consumation pizza;
    private static AnnotationConfigApplicationContext ctx;

    @AfterAll
    static void afterAll() {
        ctx.close();
    }

    @BeforeEach
    void beforeEach() {
        ctx = new AnnotationConfigApplicationContext(MenuApplication.class);
        pizza = ctx.getBean(PizzaMargherita.class);
    }

    @Test
    void testDoubleExtraPrice() {
        pizza = new ExtraProsciuttoDecorator(pizza);
        pizza = new ExtraAnanasDecorator(pizza);
        double price = pizza.getPrice();
        assertEquals(8.0, price);
    }


    @Test
    void testExtraProsciuttoPrice() {
        double priceProsciutto = new ExtraProsciuttoDecorator(pizza).getPrice();
        assertEquals(6.0, priceProsciutto);
    }

    @Test
    void testExtraAnanasPrice() {
        double priceAnanas = new ExtraAnanasDecorator(pizza).getPrice();
        assertEquals(7.0, priceAnanas);
    }

    @Test
    void testExtraSalamiPrice() {
        double priceSalami = new ExtraSalameDecorator(pizza).getPrice();
        assertEquals(6.5, priceSalami);
    }


}

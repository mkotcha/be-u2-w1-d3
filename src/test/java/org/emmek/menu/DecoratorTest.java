package org.emmek.menu;

import lombok.extern.slf4j.Slf4j;
import org.emmek.menu.decorator.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
@Slf4j
public class DecoratorTest {
    static Consumation pizza;
    private static AnnotationConfigApplicationContext ctx;

    @BeforeAll
    static void beforeAll() {
        ctx = new AnnotationConfigApplicationContext(MenuApplication.class);
        pizza = ctx.getBean(PizzaMargherita.class);
    }

    private static void assertEquals(double v, double priceAnanas) {
    }

    @AfterAll
    static void afterAll() {
        ctx.close();
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

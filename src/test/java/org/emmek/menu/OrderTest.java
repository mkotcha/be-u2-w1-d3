package org.emmek.menu;

import lombok.extern.slf4j.Slf4j;
import org.emmek.menu.entities.Menu;
import org.emmek.menu.entities.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class OrderTest {

    private static AnnotationConfigApplicationContext ctx;
    Order order;

    @BeforeAll
    static void beforeAll() {
        ctx = new AnnotationConfigApplicationContext(MenuApplication.class);
    }

    @BeforeEach
    void beforeEach() {
        order = ctx.getBean(Order.class);
        Menu menu = ctx.getBean("getEmptyMenu", Menu.class);
        order.setMenu(menu);
    }


    @Test
    void emptyOrder() {
        double price = order.getPrice();

        assertEquals(0, price);
    }

}

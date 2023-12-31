package org.emmek.menu;

import lombok.extern.slf4j.Slf4j;
import org.emmek.menu.entities.Menu;
import org.emmek.menu.entities.Order;
import org.emmek.menu.entities.Table;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
class OrderTest {

    private static AnnotationConfigApplicationContext ctx;
    Order order;

    @BeforeAll
    static void beforeAll() {
        ctx = new AnnotationConfigApplicationContext(MenuApplication.class);
    }

    @Test
    void tableOverflow() {
        Table table = ctx.getBean("getTable", Table.class);
        order.setTable(table);
        assertTrue(table.getSeats() >= order.getSeats());
    }

    @BeforeEach
    void beforeEach() {
        order = ctx.getBean(Order.class);
        Menu menu = ctx.getBean("getEmptyMenu", Menu.class);
        order.setMenu(menu);
        Table table = ctx.getBean("getTable", Table.class);
        order.setTable(table);
    }

    @Test
    void emptyOrder() {
        double price = order.getPrice();
        double expected = order.getSeats() * 2;
        assertEquals(expected, price);
    }

}

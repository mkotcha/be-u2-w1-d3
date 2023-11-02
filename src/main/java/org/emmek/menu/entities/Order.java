package org.emmek.menu.entities;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Random;

@Component
@Data
@PropertySource("application.properties")
public class Order {
    static int orderNumber = 1;
    Menu menu;
    Table table;
    OrderState orderState = OrderState.READY;
    int seats;
    LocalTime orderTime = LocalTime.now();
    @Value("${order.seat}")
    double seatPrice;

    public Order() {
        orderNumber++;
    }

    public void setTable(Table table) {
        Random random = new Random();
        table.setAvailable(false);
        this.table = table;
        seats = random.nextInt(table.getSeats()) + 1;
    }

    public double getPrice() {
        return menu.getPrice() + seats * seatPrice;
    }

    public void printOrder() {
        System.out.println("Order number: " + orderNumber);
        System.out.println("Table number: " + table.getTableNumber());
        System.out.println("Seats: " + seats + " / " + table.getSeats());
        System.out.println("Order time: " + orderTime);
        System.out.println("Order state: " + orderState);
        System.out.println();
        menu.getPizzas().forEach(System.out::println);
        menu.getDrinks().forEach(System.out::println);
        System.out.println("Order price: " + getPrice());
        System.out.println();
    }

}

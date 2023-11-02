package org.emmek.menu.entities;

import lombok.Data;
import lombok.Getter;


@Getter
@Data
public class Table {
    private final int seats;
    private final int tableNumber;
    private boolean isAvailable;

    public Table(int tableNumber, int seats) {
        this.tableNumber = tableNumber;
        this.seats = seats;
        isAvailable = true;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

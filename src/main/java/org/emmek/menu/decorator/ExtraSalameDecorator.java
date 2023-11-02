package org.emmek.menu.decorator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ExtraSalameDecorator extends ExtraAddictionDecorator {

    public ExtraSalameDecorator(@Qualifier("pizzaMargherita") Consumation consumation) {
        this.consumation = consumation;
        isXl = consumation.isXl;
    }

    @Override
    public String getProductName() {
        if (isXl) {
            return "Pizza XL";
        }
        return "Salami Pizza";
    }

    @Override
    public String getIngredients() {
        return consumation.getIngredients() + ", salame";
    }

    public String getSingleIngredient() {
        return "salame";
    }

    public double getPrice() {
        return consumation.getPrice() + 1.5;
    }

    @Override
    public void singlePrint() {
        System.out.println(getSingleIngredient() + " - 1,50€\n");
    }
}

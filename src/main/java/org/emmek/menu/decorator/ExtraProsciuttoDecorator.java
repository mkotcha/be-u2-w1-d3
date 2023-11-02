package org.emmek.menu.decorator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ExtraProsciuttoDecorator extends ExtraAddictionDecorator {

    public ExtraProsciuttoDecorator(@Qualifier("pizzaMargherita") Consumation consumation) {
        this.consumation = consumation;
        isXl = consumation.isXl;
    }

    @Override
    public String getProductName() {
        if (isXl) {
            return "Pizza XL";
        }
        return consumation.getProductName();
    }

    @Override
    public String getIngredients() {
        return consumation.getIngredients() + ", prosciutto";
    }

    public String getSingleIngredient() {
        return "prosciutto";
    }

    @Override
    public void singlePrint() {
        System.out.println(getSingleIngredient() + " - 1,00€");
    }

    public double getPrice() {
        return consumation.getPrice() + 1;
    }
}

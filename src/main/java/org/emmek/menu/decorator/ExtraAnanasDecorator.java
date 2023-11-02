package org.emmek.menu.decorator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ExtraAnanasDecorator extends ExtraAddictionDecorator {


    public ExtraAnanasDecorator(@Qualifier("pizzaMargherita") Consumation consumation) {
        this.consumation = consumation;
        isXl = consumation.isXl;
    }

    @Override
    public String getProductName() {
        if (isXl) {
            return "Pizza XL";
        }
        return "Hawaiian Pizza";
    }

    @Override
    public String getIngredients() {
        return consumation.getIngredients() + ", ananas";
    }

    public String getSingleIngredient() {
        return "ananas";
    }

    public double getPrice() {
        return consumation.getPrice() + 2;
    }

    public void singlePrint() {
        System.out.println(getSingleIngredient() + " - 2,00€");
    }
}

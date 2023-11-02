package org.emmek.menu.decorator;

public abstract class ExtraAddictionDecorator extends Consumation {
    protected Consumation consumation;

    @Override
    public abstract String getProductName();

    @Override
    public abstract String getIngredients();

    public abstract String getSingleIngredient();

    public abstract void singlePrint();

}

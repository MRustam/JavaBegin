package ru.rmamedov.tutorial.shop.visitor;

import ru.rmamedov.tutorial.shop.interfaces.IVisitor;

public class BaseVisitor implements IVisitor{

    private String name;

    public BaseVisitor(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void spendMmoney() {

    }
}
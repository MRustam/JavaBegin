package ru.rmamedov.tutorial.shop.visitor;

import ru.rmamedov.tutorial.shop.interfaces.InterfaceDepartment;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceGood;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceVisitor;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceWorker;

import java.util.ArrayList;

public abstract class AbstractVisitor implements InterfaceVisitor {

    private String name;
    private int spendedMoney;
    private boolean discontCard;
    private InterfaceWorker worker;
    private InterfaceDepartment department;


    // Quantity of goods.
    private ArrayList<InterfaceGood> alredyBoughtList
            = new ArrayList<InterfaceGood>();

    public AbstractVisitor(String name) {
        this.name = name;
        discontCard = false;
    }

    @Override
    public String getName() {
        return name;
    }


    // Bought.
    public ArrayList<InterfaceGood> getAlredyBoughtList() {
        return alredyBoughtList;
    }
    public void setAlredyBoughtList(InterfaceGood good) {
        alredyBoughtList.add(good);
    }




    // Bay good.
    @Override
    public void bay(InterfaceGood good) {
        System.out.println("Bay " + good.getName());
    }




    // Spended money;
    @Override
    public int getSpendedMoney() {
        return spendedMoney;
    }
    @Override
    public void setSpendedMoney(int price) {
        spendedMoney += price;
    }

    // Card.
    @Override
    public boolean getDiscontCard() {
        return discontCard;
    }
    @Override
    public void setDiscontCard(boolean discontCard) {
        this.discontCard = discontCard;
    }
}
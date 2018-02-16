package ru.rmamedov.tutorial.shop.interfaces;

import java.util.ArrayList;

public interface InterfaceVisitor {

    String getName();
    void bay(InterfaceGood good);

    int getSpendedMoney();
    void setSpendedMoney(int price);

    boolean getDiscontCard();
    void setDiscontCard(boolean card);

    void setAlredyBoughtList(InterfaceGood good);
    ArrayList<InterfaceGood> getAlredyBoughtList();

}
package ru.rmamedov.tutorial.shop.interfaces;

import java.util.ArrayList;

public interface InterfaceDepartment {

    ArrayList<InterfaceWorker> getWorkerList();
    void addGood(InterfaceGood good);
    void addWorker(InterfaceWorker worker);
}
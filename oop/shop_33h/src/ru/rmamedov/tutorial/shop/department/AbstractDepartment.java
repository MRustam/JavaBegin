package ru.rmamedov.tutorial.shop.department;

import ru.rmamedov.tutorial.shop.interfaces.InterfaceDepartment;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceGood;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceWorker;

import java.util.ArrayList;

public abstract class AbstractDepartment implements InterfaceDepartment {

    public AbstractDepartment() {
    }

    // Worker List.
    private ArrayList<InterfaceWorker> workerList = new ArrayList<InterfaceWorker>();
    // Good List.
    private ArrayList<InterfaceGood> goodList = new ArrayList<InterfaceGood>();


    // Add good.
    public void addGood(InterfaceGood good) {
        good.setDepartment(this);
        goodList.add(good);
    }
    // Good List.
    public ArrayList<InterfaceGood> getGoodList() {
        return goodList;
    }


    // Add worker.
    public void addWorker(InterfaceWorker worker) {
        worker.setDepartment(this);
        workerList.add(worker);
    }
    public ArrayList<InterfaceWorker> getWorkerList() {
        return workerList;
    }
}
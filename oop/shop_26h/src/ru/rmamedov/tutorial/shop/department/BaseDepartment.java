package ru.rmamedov.tutorial.shop.department;

import ru.rmamedov.tutorial.shop.interfaces.IDepartment;
import ru.rmamedov.tutorial.shop.interfaces.IGood;
import ru.rmamedov.tutorial.shop.interfaces.IWorker;

import java.util.ArrayList;

public class BaseDepartment implements IDepartment{

    private String name;
    private ArrayList <IWorker> workerList;
    private ArrayList <IGood> goodList;

    public BaseDepartment(String name) {
        this.name = name;
    }

    public BaseDepartment(String name, ArrayList<IWorker> workerList) {
        this.name = name;
        this.workerList = workerList;
    }

    public BaseDepartment(String name, ArrayList<IWorker> workerList, ArrayList<IGood> goodList) {
        this.name = name;
        this.workerList = workerList;
        this.goodList = goodList;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<IWorker> getWorkerList() {
        return workerList;
    }

    @Override
    public ArrayList<IGood> getGoodList() {
        return goodList;
    }
}
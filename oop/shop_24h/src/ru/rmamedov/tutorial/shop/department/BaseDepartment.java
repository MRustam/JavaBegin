package ru.rmamedov.tutorial.shop.department;

import ru.rmamedov.tutorial.shop.good.BaseGood;
import ru.rmamedov.tutorial.shop.worker.BaseWorker;

import java.util.ArrayList;

public class BaseDepartment {

    private String name;
    private ArrayList <BaseWorker> baseWorkers;
    private ArrayList <BaseGood> baseGoods;

    public BaseDepartment(String name) {
        this.name = name;
    }

    public BaseDepartment(String name, ArrayList<BaseWorker> baseWorkers) {
        this.name = name;
        this.baseWorkers = baseWorkers;
    }

    public BaseDepartment(String name, ArrayList<BaseWorker> baseWorkers, ArrayList<BaseGood> baseGoods) {
        this.name = name;
        this.baseWorkers = baseWorkers;
        this.baseGoods = baseGoods;
    }
}
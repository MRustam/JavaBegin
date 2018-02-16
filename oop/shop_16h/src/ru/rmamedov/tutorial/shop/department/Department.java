package ru.rmamedov.tutorial.shop.department;

import ru.rmamedov.tutorial.shop.good.Good;
import ru.rmamedov.tutorial.shop.worker.Worker;

import java.util.ArrayList;

public class Department {

    private String name;
    private ArrayList <Worker> workers;
    private ArrayList <Good> goods;

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, ArrayList<Worker> workers) {
        this.name = name;
        this.workers = workers;
    }

    public Department(String name, ArrayList<Worker> workers, ArrayList<Good> goods) {
        this.name = name;
        this.workers = workers;
        this.goods = goods;
    }
}
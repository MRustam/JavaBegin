package ru.rmamedov.tutorial.shop.department.electronicDepartment;

import ru.rmamedov.tutorial.shop.department.Department;
import ru.rmamedov.tutorial.shop.good.Good;
import ru.rmamedov.tutorial.shop.worker.Worker;

import java.util.ArrayList;

public class ElectronicDep extends Department {

    public ElectronicDep(String name) {
        super(name);
    }

    public ElectronicDep(String name, ArrayList<Worker> workers) {
        super(name, workers);
    }

    public ElectronicDep(String name, ArrayList<Worker> workers, ArrayList<Good> goods) {
        super(name, workers, goods);
    }

}
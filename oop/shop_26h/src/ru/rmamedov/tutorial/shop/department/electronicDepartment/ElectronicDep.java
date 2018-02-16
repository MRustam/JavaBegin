package ru.rmamedov.tutorial.shop.department.electronicDepartment;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.interfaces.IGood;
import ru.rmamedov.tutorial.shop.interfaces.IWorker;

import java.util.ArrayList;

public class ElectronicDep extends BaseDepartment {

    public ElectronicDep(String name) {
        super(name);
    }

    public ElectronicDep(String name, ArrayList<IWorker> workerList) {
        super(name, workerList);
    }

    public ElectronicDep(String name, ArrayList<IWorker> workerList, ArrayList<IGood> goodList) {
        super(name, workerList, goodList);
    }

}
package ru.rmamedov.tutorial.shop.department.electronicDepartment;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.BaseGood;
import ru.rmamedov.tutorial.shop.worker.BaseWorker;

import java.util.ArrayList;

public class ElectronicDep extends BaseDepartment {

    public ElectronicDep(String name) {
        super(name);
    }

    public ElectronicDep(String name, ArrayList<BaseWorker> baseWorkers) {
        super(name, baseWorkers);
    }

    public ElectronicDep(String name, ArrayList<BaseWorker> baseWorkers, ArrayList<BaseGood> baseGoods) {
        super(name, baseWorkers, baseGoods);
    }

}
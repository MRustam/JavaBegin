package ru.rmamedov.tutorial.shop.department.clothesDepartment;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.BaseGood;
import ru.rmamedov.tutorial.shop.interfaces.IGood;
import ru.rmamedov.tutorial.shop.interfaces.IWorker;
import ru.rmamedov.tutorial.shop.worker.BaseWorker;

import java.util.ArrayList;

public class ClotheDep extends BaseDepartment {

    public ClotheDep(String name) {
        super(name);
    }

    public ClotheDep(String name, ArrayList<IWorker> workerList) {
        super(name, workerList);
    }

    public ClotheDep(String name, ArrayList<IWorker> workerList, ArrayList<IGood> goodList) {
        super(name, workerList, goodList);
    }
}
package ru.rmamedov.tutorial.shop.department.clothesDepartment;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.BaseGood;
import ru.rmamedov.tutorial.shop.worker.BaseWorker;

import java.util.ArrayList;

public class ClotheDep extends BaseDepartment {

    public ClotheDep(String name) {
        super(name);
    }

    public ClotheDep(String name, ArrayList<BaseWorker> baseWorkers) {
        super(name, baseWorkers);
    }

    public ClotheDep(String name, ArrayList<BaseWorker> baseWorkers, ArrayList<BaseGood> baseGoods) {
        super(name, baseWorkers, baseGoods);
    }
}
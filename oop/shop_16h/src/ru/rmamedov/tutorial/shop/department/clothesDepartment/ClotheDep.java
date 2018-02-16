package ru.rmamedov.tutorial.shop.department.clothesDepartment;

import ru.rmamedov.tutorial.shop.department.Department;
import ru.rmamedov.tutorial.shop.good.Good;
import ru.rmamedov.tutorial.shop.worker.Worker;

import java.util.ArrayList;

public class ClotheDep extends Department {

    public ClotheDep(String name) {
        super(name);
    }

    public ClotheDep(String name, ArrayList<Worker> workers) {
        super(name, workers);
    }

    public ClotheDep(String name, ArrayList<Worker> workers, ArrayList<Good> goods) {
        super(name, workers, goods);
    }
}
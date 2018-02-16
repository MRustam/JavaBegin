package ru.rmamedov.tutorial.shop.worker.consutant;

import ru.rmamedov.tutorial.shop.department.Department;
import ru.rmamedov.tutorial.shop.worker.Worker;

public class Consultant extends Worker {

    public Consultant(String name) {
        super(name);
    }
    public Consultant(String name, Department department) {
        super(name, department);
    }

    public void describeGoods() {

    }
    private void sentToCassa() {

    }
}
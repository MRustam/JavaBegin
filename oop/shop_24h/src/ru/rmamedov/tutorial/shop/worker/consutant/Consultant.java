package ru.rmamedov.tutorial.shop.worker.consutant;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.worker.BaseWorker;

public class Consultant extends BaseWorker {

    public Consultant(String name) {
        super(name);
    }
    public Consultant(String name, BaseDepartment baseDepartment) {
        super(name, baseDepartment);
    }

    public void describeGoods() {

    }
    private void sentToCassa() {

    }
}
package ru.rmamedov.tutorial.shop.worker.consutant;

import ru.rmamedov.tutorial.shop.interfaces.IDepartment;
import ru.rmamedov.tutorial.shop.worker.BaseWorker;

public class Consultant extends BaseWorker {

    public Consultant(String name) {
        super(name);
    }
    public Consultant(String name, IDepartment department) {
        super(name, department);
    }

    public void describeGoods() {

    }
    private void sentToCassa() {

    }
}
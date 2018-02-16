package ru.rmamedov.tutorial.shop.worker.security;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.worker.BaseWorker;

public class Security extends BaseWorker {

    public Security(String name) {
        super(name);
    }

    public Security(String name, BaseDepartment baseDepartment) {
        super(name, baseDepartment);
    }

    public void checkVisitors() {

    }
}
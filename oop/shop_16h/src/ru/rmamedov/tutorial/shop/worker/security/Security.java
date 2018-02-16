package ru.rmamedov.tutorial.shop.worker.security;

import ru.rmamedov.tutorial.shop.department.Department;
import ru.rmamedov.tutorial.shop.worker.Worker;

public class Security extends Worker {

    public Security(String name) {
        super(name);
    }

    public Security(String name, Department department) {
        super(name, department);
    }

    public void checkVisitors() {

    }
}
package ru.rmamedov.tutorial.shop.worker.security.outdoor;

import ru.rmamedov.tutorial.shop.department.Department;
import ru.rmamedov.tutorial.shop.worker.security.Security;

public class OutdoorSecurity extends Security {

    public OutdoorSecurity(String name) {
        super(name);
    }

    public OutdoorSecurity(String name, Department department) {
        super(name, department);
    }

    public void panish() {

    }
    public void letToGo() {

    }
}
package ru.rmamedov.tutorial.shop.worker.security.outdoor;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.worker.security.Security;

public class OutdoorSecurity extends Security {

    public OutdoorSecurity(String name) {
        super(name);
    }

    public OutdoorSecurity(String name, BaseDepartment baseDepartment) {
        super(name, baseDepartment);
    }

    public void panish() {

    }
    public void letToGo() {

    }
}
package ru.rmamedov.tutorial.shop.worker;

import ru.rmamedov.tutorial.shop.interfaces.IDepartment;
import ru.rmamedov.tutorial.shop.interfaces.IWorker;

public abstract class BaseWorker implements IWorker{

    private String name;
    private int salary;
    private int scores;
    private IDepartment department;

    public BaseWorker(String name) {
        this.name = name;
    }
    public BaseWorker(String name, IDepartment department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public int getScore() {
        return scores;
    }

    @Override
    public IDepartment getDepertment() {
        return department;
    }
}
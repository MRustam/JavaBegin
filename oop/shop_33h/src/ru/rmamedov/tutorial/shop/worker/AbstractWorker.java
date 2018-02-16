package ru.rmamedov.tutorial.shop.worker;

import ru.rmamedov.tutorial.shop.interfaces.InterfaceDepartment;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceWorker;

public abstract class AbstractWorker implements InterfaceWorker {

    private String name;
    private int salary;
    private int scores;

    private InterfaceDepartment department;

    public AbstractWorker() {
        salary = 500;
        scores = 0;
    }

    public AbstractWorker(String name) {
        this.name = name;
        salary = 500;
        scores = 0;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public void setDepartment(InterfaceDepartment department) {
        this.department = department;
    }
}
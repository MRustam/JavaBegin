package ru.rmamedov.tutorial.shop.worker;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;

public class BaseWorker {

    private String name;
    private int salary;
    private int scores;
    private BaseDepartment baseDepartment;



    public BaseWorker(String name) {
        this.name = name;
    }
    public BaseWorker(String name, BaseDepartment baseDepartment) {
        this.name = name;
        this.baseDepartment = baseDepartment;
    }



    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
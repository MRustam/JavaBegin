package ru.rmamedov.tutorial.shop.worker;

import ru.rmamedov.tutorial.shop.department.Department;

public class Worker {

    private String name;
    private int salary;
    private int scores;
    private Department department;



    public Worker(String name) {
        this.name = name;
    }
    public Worker(String name, Department department) {
        this.name = name;
        this.department = department;
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
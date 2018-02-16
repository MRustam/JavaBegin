package ru.rmamedov.tutorial.shop.interfaces;

public interface InterfaceWorker {

    int getSalary();
    void setSalary(int salary);
    int getScores();
    void setScores(int scores);

    void setDepartment(InterfaceDepartment department);

}
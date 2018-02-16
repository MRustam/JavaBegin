package ru.rmamedov.tutorial.shop.worker.security;

import ru.rmamedov.tutorial.shop.interfaces.InterfaceDepartment;
import ru.rmamedov.tutorial.shop.worker.AbstractWorker;

public abstract class AbstractSecurity extends AbstractWorker {

    public AbstractSecurity() {

    }

    @Override
    public int getSalary() {
        return super.getSalary();
    }

    @Override
    public void setSalary(int salary) {
        super.setSalary(salary);
    }

    @Override
    public int getScores() {
        return super.getScores();
    }

    @Override
    public void setScores(int scores) {
        super.setScores(scores);
    }

    @Override
    public void setDepartment(InterfaceDepartment department) {
        super.setDepartment(department);
    }
}
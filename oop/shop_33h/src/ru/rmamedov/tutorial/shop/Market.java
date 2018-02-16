package ru.rmamedov.tutorial.shop;

import ru.rmamedov.tutorial.shop.interfaces.InterfaceDepartment;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceVisitor;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceWorker;
import ru.rmamedov.tutorial.shop.worker.consutant.Consultant;

import java.util.ArrayList;

public class Market {


    // Department list.
    private ArrayList<InterfaceDepartment> departmentList =
            new ArrayList<InterfaceDepartment>();

    // Visitor list.
    private ArrayList<InterfaceVisitor> visitorList =
            new ArrayList<InterfaceVisitor>();

    // Get consultants description.
    private InterfaceWorker worker;

    // Add department.
    public void addDepartment(InterfaceDepartment department) {
        departmentList.add(department);
    }
    public ArrayList<InterfaceDepartment> getDepartmentList() {
        return departmentList;
    }


    // Add new visitor.

    public void addVisitor(InterfaceVisitor visitor) {
        visitorList.add(visitor);
    }
    public ArrayList<InterfaceVisitor> getVisitorList() {
        return visitorList;
    }


    public Consultant getConsultant(InterfaceDepartment department) {
        for (InterfaceWorker worker : department.getWorkerList()) {
            if (worker instanceof Consultant) {
                return ((Consultant) worker);
            }
        }
        return null;
    }
}
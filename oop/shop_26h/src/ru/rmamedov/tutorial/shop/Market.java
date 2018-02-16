package ru.rmamedov.tutorial.shop;

import ru.rmamedov.tutorial.shop.interfaces.IDepartment;
import ru.rmamedov.tutorial.shop.interfaces.IVisitor;
import ru.rmamedov.tutorial.shop.worker.admin.Admin;

import java.util.ArrayList;

public class Market {

    private String name;
    private Admin admin;

    private ArrayList <IDepartment> departmentList;
    private ArrayList <IVisitor> visitorList;
}
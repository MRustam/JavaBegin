package ru.rmamedov.tutorial.shop;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.visitor.BaseVisitor;
import ru.rmamedov.tutorial.shop.worker.admin.Admin;

import java.util.ArrayList;

public class Market {

    private String name;
    private Admin admin;

    private ArrayList <BaseDepartment> baseDepartments;
    private ArrayList <BaseVisitor> baseVisitors;
}
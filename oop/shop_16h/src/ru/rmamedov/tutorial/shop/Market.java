package ru.rmamedov.tutorial.shop;

import ru.rmamedov.tutorial.shop.department.Department;
import ru.rmamedov.tutorial.shop.visitor.Visitor;
import ru.rmamedov.tutorial.shop.worker.admin.Admin;

import java.util.ArrayList;

public class Market {

    private String name;
    private Admin admin;

    private ArrayList <Department> departments;
    private ArrayList <Visitor> visitors;
}
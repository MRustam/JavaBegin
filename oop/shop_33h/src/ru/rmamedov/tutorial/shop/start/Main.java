package ru.rmamedov.tutorial.shop.start;

import ru.rmamedov.tutorial.shop.Market;
import ru.rmamedov.tutorial.shop.department.SaleDep;
import ru.rmamedov.tutorial.shop.department.clothesDepartment.ClotheDep;
import ru.rmamedov.tutorial.shop.department.electronicDepartment.ElectronicDep;
import ru.rmamedov.tutorial.shop.good.clothe.outweare.coat.Coat;
import ru.rmamedov.tutorial.shop.good.electronic.audio.amplifer.Pioneer305;
import ru.rmamedov.tutorial.shop.good.electronic.audio.headphones.JBL300Ch;
import ru.rmamedov.tutorial.shop.good.electronic.video.reciver.OpenBox100;
import ru.rmamedov.tutorial.shop.good.electronic.video.tv.SonyBravia;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceVisitor;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceDepartment;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceGood;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceWorker;
import ru.rmamedov.tutorial.shop.visitor.visitor.Visitor;
import ru.rmamedov.tutorial.shop.worker.consutant.Consultant;
import ru.rmamedov.tutorial.shop.worker.saller.Cashier;
import ru.rmamedov.tutorial.shop.worker.security.outdoor.OutdoorSecurity;

public class Main {
    public static void main(String[] args) {

        // Create market.
        Market market = new Market();

        // Create and add two consumers.
        InterfaceVisitor visitor1 = new Visitor("Tim");
        InterfaceVisitor visitor2 = new Visitor("Tom");


        // Add department.
        InterfaceDepartment electronicDep = new ElectronicDep();
        InterfaceDepartment clotheDep = new ClotheDep();
        InterfaceDepartment saleDep = new SaleDep();
        market.addDepartment(electronicDep);
        market.addDepartment(clotheDep);
        market.addDepartment(saleDep);


        // Create and add consultants.
        InterfaceWorker consultant1 = new Consultant("Jack");
        InterfaceWorker consultant2 = new Consultant("Bob");
        electronicDep.addWorker(consultant1);
        electronicDep.addWorker(consultant2);



        // Create and add goods.
        InterfaceGood tv = new SonyBravia("SonyBravia", 1000,
                500, 51);
        electronicDep.addGood(tv);

        InterfaceGood reciver = new OpenBox100("Openbox 100", 250,
                2000, 50);
        electronicDep.addGood(reciver);

        InterfaceGood amlifier = new Pioneer305("Pioneer 305", 700,
                150, "aluminium");
        electronicDep.addGood(amlifier);

        InterfaceGood headphone = new JBL300Ch("JBL 300 Ch", 150,
                20, 8);
        electronicDep.addGood(headphone);

        InterfaceGood coat = new Coat("Zara Man Coat", 110,
                "Spain", "Gray", true);
        clotheDep.addGood(coat);



        // Create and add cashier.
        InterfaceWorker cashier1 = new Cashier("Saller1");
        saleDep.addWorker(cashier1);


        // Create and add security.
        InterfaceWorker security = new
                OutdoorSecurity();
        saleDep.addWorker(security);

        // Acton in to Market.

        market.getConsultant(electronicDep).describeGood(coat);
        visitor1.bay(amlifier);
        ((OutdoorSecurity)security).checkVisitor(visitor1);

    }
}
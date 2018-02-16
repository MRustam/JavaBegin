package ru.rmamedov.tutorial.shop.good.electronic.audio.amplifer;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.electronic.audio.Audio;

public class Pioneer305 extends Audio {

     private String material;

    public Pioneer305(String name, int outputPower, String material) {
        super(name, outputPower);
        this.material = material;
    }

    public Pioneer305(String name, int price, int outputPower, String material) {
        super(name, price, outputPower);
        this.material = material;
    }

    public Pioneer305(String name, int price, int varrenty, int outputPower, String material) {
        super(name, price, varrenty, outputPower);
        this.material = material;
    }

    public Pioneer305(String name, int price, int varrenty, BaseDepartment baseDepartment, int outputPower, String material) {
        super(name, price, varrenty, baseDepartment, outputPower);
        this.material = material;
    }

    public void playDolbySorround() {

    }
}
package ru.rmamedov.tutorial.shop.good.electronic.audio.headphones;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.electronic.audio.Audio;

public class JBL300Ch extends Audio {

    private boolean portable;

    public JBL300Ch(String name, int outputPower, boolean portable) {
        super(name, outputPower);
        this.portable = portable;
    }

    public JBL300Ch(String name, int price, int outputPower, boolean portable) {
        super(name, price, outputPower);
        this.portable = portable;
    }

    public JBL300Ch(String name, int price, int varrenty, int outputPower, boolean portable) {
        super(name, price, varrenty, outputPower);
        this.portable = portable;
    }

    public JBL300Ch(String name, int price, int varrenty, BaseDepartment baseDepartment, int outputPower, boolean portable) {
        super(name, price, varrenty, baseDepartment, outputPower);
        this.portable = portable;
    }


    public void conectByBluetuth() {

    }
}
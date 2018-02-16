package ru.rmamedov.tutorial.shop.good.electronic.audio;

import ru.rmamedov.tutorial.shop.good.electronic.AbstractElectronic;
import ru.rmamedov.tutorial.shop.interfaces.goodsBehevior.InterfaceAudio;
import ru.rmamedov.tutorial.shop.interfaces.goodsBehevior.InterfaceElectronic;

public class Audio  extends AbstractElectronic implements InterfaceElectronic, InterfaceAudio {

    private int outputPower;

    public Audio(String name, int price, int outputPower) {
        super(name, price);
        this.outputPower = outputPower;
    }


    @Override
    public void playMusic() {
        System.out.println("It has Dinamic");
    }

    @Override
    public void switchOn() {
        super.switchOn();
    }
}
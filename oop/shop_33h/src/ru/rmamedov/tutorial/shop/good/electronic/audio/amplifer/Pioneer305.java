package ru.rmamedov.tutorial.shop.good.electronic.audio.amplifer;

import ru.rmamedov.tutorial.shop.good.electronic.audio.Audio;

public class Pioneer305 extends Audio {

    private String material;


    public Pioneer305(String name, int price, int outputPower, String material) {
        super(name, price, outputPower);
        this.material = material;
    }

    @Override
    public void playMusic() {
        super.playMusic();
    }

    @Override
    public void switchOn() {
        super.switchOn();
    }

    public void playDolbySorround() {
        System.out.println("5.1 channels");
    }

    @Override
    public String toString() {
        return super.toString() + "\nMade of " + material;
    }
}
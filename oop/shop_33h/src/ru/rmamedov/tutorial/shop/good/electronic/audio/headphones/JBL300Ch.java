package ru.rmamedov.tutorial.shop.good.electronic.audio.headphones;

import ru.rmamedov.tutorial.shop.good.electronic.audio.Audio;

public class JBL300Ch extends Audio {

    private int autonomy;

    public JBL300Ch(String name, int price, int outputPower, int autonomy) {
        super(name, price, outputPower);
        this.autonomy = autonomy;
    }


    public void conectByBluetuth() {
        System.out.println("Wireless connection");
    }

    @Override
    public void playMusic() {
        super.playMusic();
    }

    @Override
    public void switchOn() {
        super.switchOn();
    }

    @Override
    public String toString() {
        return super.toString() + "\nautonomy " + autonomy;
    }
}
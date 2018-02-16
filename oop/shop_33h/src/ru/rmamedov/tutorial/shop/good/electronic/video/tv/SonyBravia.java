package ru.rmamedov.tutorial.shop.good.electronic.video.tv;

import ru.rmamedov.tutorial.shop.good.electronic.video.Video;

public class SonyBravia extends Video {

    private int screenSize;

    public SonyBravia(String name, int price, int channelList, int screenSize) {
        super(name, price, channelList);
        this.screenSize = screenSize;
    }


    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public int getPrice() {
        return super.getPrice();
    }
    @Override
    public int getVarrenty() {
        return super.getVarrenty();
    }


    public void show3D() {
        System.out.println("3D mode is ON");
    }

    @Override
    public void showPicture() {
        super.showPicture();
    }

    @Override
    public void switchOn() {
        super.switchOn();
    }

    @Override
    public String toString() {
        return super.toString() + "\nscreensize " + screenSize;
    }
}
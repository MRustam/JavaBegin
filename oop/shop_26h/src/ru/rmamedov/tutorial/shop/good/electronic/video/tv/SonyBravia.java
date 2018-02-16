package ru.rmamedov.tutorial.shop.good.electronic.video.tv;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.electronic.video.Video;

public class SonyBravia extends Video {

    private int screenSize;

    public SonyBravia(String name, int channelList, int screenSize) {
        super(name, channelList);
        this.screenSize = screenSize;
    }

    public SonyBravia(String name, int price, int channelList, int screenSize) {
        super(name, price, channelList);
        this.screenSize = screenSize;
    }

    public SonyBravia(String name, int price, int varrenty, int channelList, int screenSize) {
        super(name, price, varrenty, channelList);
        this.screenSize = screenSize;
    }

    public SonyBravia(String name, int price, int varrenty, BaseDepartment baseDepartment, int channelList, int screenSize) {
        super(name, price, varrenty, baseDepartment, channelList);
        this.screenSize = screenSize;
    }


    public void show3D() {

    }

    @Override
    public void showPicture() {
        super.showPicture();
    }

    @Override
    public void switchOn() {
        super.switchOn();
    }
}
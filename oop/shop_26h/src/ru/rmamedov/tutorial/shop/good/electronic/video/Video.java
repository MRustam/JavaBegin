package ru.rmamedov.tutorial.shop.good.electronic.video;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.electronic.Electronic;
import ru.rmamedov.tutorial.shop.interfaces.goodsBehevior.IElectronics;
import ru.rmamedov.tutorial.shop.interfaces.goodsBehevior.IVideo;

public class Video extends Electronic implements IElectronics, IVideo{

    private int channelList;

    public Video(String name, int channelList) {
        super(name);
        this.channelList = channelList;
    }

    public Video(String name, int price, int channelList) {
        super(name, price);
        this.channelList = channelList;
    }

    public Video(String name, int price, int varrenty, int channelList) {
        super(name, price, varrenty);
        this.channelList = channelList;
    }

    public Video(String name, int price, int varrenty, BaseDepartment baseDepartment, int channelList) {
        super(name, price, varrenty, baseDepartment);
        this.channelList = channelList;
    }

    @Override
    public void showPicture() {

    }

    @Override
    public void switchOn() {
        super.switchOn();
    }
}
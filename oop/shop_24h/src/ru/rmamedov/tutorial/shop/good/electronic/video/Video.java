package ru.rmamedov.tutorial.shop.good.electronic.video;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.electronic.Electronic;

public class Video extends Electronic {

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
}
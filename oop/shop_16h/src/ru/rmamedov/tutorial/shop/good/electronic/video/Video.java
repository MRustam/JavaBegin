package ru.rmamedov.tutorial.shop.good.electronic.video;

import ru.rmamedov.tutorial.shop.department.Department;
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

    public Video(String name, int price, int varrenty, Department department, int channelList) {
        super(name, price, varrenty, department);
        this.channelList = channelList;
    }
}
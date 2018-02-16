package ru.rmamedov.tutorial.shop.good.electronic.video;

import ru.rmamedov.tutorial.shop.good.electronic.AbstractElectronic;
import ru.rmamedov.tutorial.shop.interfaces.goodsBehevior.InterfaceElectronic;
import ru.rmamedov.tutorial.shop.interfaces.goodsBehevior.InterfaceVideo;

public class Video extends AbstractElectronic
        implements InterfaceElectronic, InterfaceVideo {

    private int channelList;

    public Video(String name, int price, int channelList) {
        super(name, price);
        this.channelList = channelList;
    }

    public int getChannelList() {
        return channelList;
    }

    @Override
    public void showPicture() {
        System.out.println("Picture on monitor");
    }
}
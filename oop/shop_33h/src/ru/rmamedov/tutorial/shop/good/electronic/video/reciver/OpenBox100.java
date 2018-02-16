package ru.rmamedov.tutorial.shop.good.electronic.video.reciver;

import ru.rmamedov.tutorial.shop.good.electronic.video.Video;

public class OpenBox100 extends Video {

    private int hdChannels;

    public OpenBox100(String name, int price, int channelList,
                      int hdChannels) {
        super(name, price, channelList);
        this.hdChannels = hdChannels;
    }

    public int getHdChannels() {
        System.out.println("HD tv");
        return hdChannels;
    }

    @Override
    public void showPicture() {
        super.showPicture();
    }

    @Override
    public void switchOn() {
        super.switchOn();
    }

    public void resiveSignal() {
        System.out.println("recive digital signal from anten");
    }

    @Override
    public String toString() {
        return super.toString() + "\nHD Channels " + hdChannels;
    }
}
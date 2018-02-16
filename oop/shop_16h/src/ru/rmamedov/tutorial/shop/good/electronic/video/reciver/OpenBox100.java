package ru.rmamedov.tutorial.shop.good.electronic.video.reciver;

import ru.rmamedov.tutorial.shop.department.Department;
import ru.rmamedov.tutorial.shop.good.electronic.video.Video;

public class OpenBox100 extends Video {

    private boolean hdChannels;

    public OpenBox100(String name, int channelList, boolean hdChannels) {
        super(name, channelList);
        this.hdChannels = hdChannels;
    }

    public OpenBox100(String name, int price, int channelList, boolean hdChannels) {
        super(name, price, channelList);
        this.hdChannels = hdChannels;
    }

    public OpenBox100(String name, int price, int varrenty, int channelList, boolean hdChannels) {
        super(name, price, varrenty, channelList);
        this.hdChannels = hdChannels;
    }

    public OpenBox100(String name, int price, int varrenty, Department department, int channelList, boolean hdChannels) {
        super(name, price, varrenty, department, channelList);
        this.hdChannels = hdChannels;
    }


    public void resiveSignal() {

    }
}
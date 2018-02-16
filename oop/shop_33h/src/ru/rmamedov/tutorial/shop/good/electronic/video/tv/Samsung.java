package ru.rmamedov.tutorial.shop.good.electronic.video.tv;

import ru.rmamedov.tutorial.shop.good.electronic.video.Video;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceDepartment;

public class Samsung extends Video {
    public Samsung(String name, int price, int channelList) {
        super(name, price, channelList);
    }

    @Override
    public int getChannelList() {
        return super.getChannelList();
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
    public void setDepartment(InterfaceDepartment department) {
        super.setDepartment(department);
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

    @Override
    public String toString() {
        return super.toString();
    }
}

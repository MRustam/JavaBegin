package ru.rmamedov.javabegin.gui;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    public Panel() {
    }

    public Panel(String name, int width, int height) {

        super.setName(name);
        super.setSize(width, height);
        super.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    public Panel(String name, int width, int height, Component component) {
        this(name, width, height);
        super.add(component);
    }

    public void addComponent(Component component) {
        super.add(component);
    }
}
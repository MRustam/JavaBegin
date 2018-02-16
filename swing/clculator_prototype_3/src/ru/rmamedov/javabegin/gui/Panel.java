package ru.rmamedov.javabegin.gui;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {


    public Panel() {
        super.setLayout(null);
        super.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    public Panel(LayoutManager layoutManager) {
        super.setLayout(null);
        super.setBorder(BorderFactory.createRaisedBevelBorder());
        super.setLayout(layoutManager);
    }


    public Panel(int width, int height) {
        super.setSize(width, height);
        super.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    public Panel(int width, int height, LayoutManager layoutManager) {
        this(width, height);
        super.setLayout(null);
        super.setBorder(BorderFactory.createRaisedBevelBorder());
        super.setLayout(layoutManager);
    }
}
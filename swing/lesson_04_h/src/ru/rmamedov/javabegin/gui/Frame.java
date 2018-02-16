package ru.rmamedov.javabegin.gui;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame (String title, int width, int height) {
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        //super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    public Frame (String title, int width, int height, Component component) {
        this(title, width, height);
        super.add(component);
    }
}
package ru.rmamedov.javabegin.gui;

import javax.swing.*;

public class Label extends JLabel {

    public Label() {

    }

    public Label(String text) {
        super(text);
    }

    public Label(String text, int width, int height) {
        super(text);
        super.setSize(width, height);
    }
}

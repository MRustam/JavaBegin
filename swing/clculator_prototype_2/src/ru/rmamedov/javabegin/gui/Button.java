package ru.rmamedov.javabegin.gui;

import javax.swing.*;

public class Button extends JButton {

    public Button() {
    }

    public Button(String text) {
        super(text);
    }

    public Button(String text, int width, int height) {
        super(text);
        super.setSize(width, height);
    }
}

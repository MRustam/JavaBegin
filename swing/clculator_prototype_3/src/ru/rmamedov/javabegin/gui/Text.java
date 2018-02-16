package ru.rmamedov.javabegin.gui;

import javax.swing.*;

public class Text extends JTextField {

    public Text() {
        super.setHorizontalAlignment(JTextField.RIGHT);
    }

    public Text(int widht, int height) {
        super.setSize(widht, height);
        super.setHorizontalAlignment(JTextField.RIGHT);
    }

    public Text(String text, int widht, int height) {
        super(text);
        super.setSize(widht, height);
        super.setHorizontalAlignment(JTextField.RIGHT);
    }
}

package ru.rmamedov.javabegin.gui;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
    }

    public Frame(String title) throws HeadlessException {
        super(title);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
    }

    public Frame (String title, int width, int height) {
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
    }

    public Frame (String title, int width, int height, LayoutManager layoutManager) {
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        super.setLayout(null);
        super.setLayout(layoutManager);
        super.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
    }

}
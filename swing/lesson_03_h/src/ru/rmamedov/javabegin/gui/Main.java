package ru.rmamedov.javabegin.gui;

import com.alee.laf.WebLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new TextureLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        Button button1 = new Button("button 1", 100, 50);
        Button button2 = new Button("button 1", 100, 50);
        Button button3 = new Button("button 1", 100, 50);
        Panel panel = new Panel("panel 1", 400, 300, button1);
        panel.addComponent(button2);
        panel.addComponent(button3);

        JFrame.setDefaultLookAndFeelDecorated(true);
        Frame frame = new Frame("main frame", 600, 600, panel);
        frame.setIconImage(new ImageIcon("/Users/rustam/java/" +
                "tutorials_by_javabegin_ru/swing/icons/PNG/64x64/twitter.png").getImage());

    }
}
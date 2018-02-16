package ru.rmamedov.javabegin.gui;

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
        Button button2 = new Button("button 2", 100, 50);
        Button button3 = new Button("button 3", 100, 50);
        Button button4 = new Button("button 4", 100, 50);
        Button button5 = new Button("button 5", 100, 50);
        Button button6 = new Button("button 6", 100, 50);
        Button button7 = new Button("button 7", 100, 50);
        Button button8 = new Button("button 8", 100, 50);
        Button button9 = new Button("button 9", 100, 50);
        Button button10 = new Button("button 10", 100, 50);

        Panel panel = new Panel("panel 1", 400, 300, button1);
        panel.addComponent(button2);
        panel.addComponent(button3);
        panel.addComponent(button4);
        panel.addComponent(button5);
        panel.addComponent(button6);
        panel.addComponent(button7);
        panel.addComponent(button8);
        panel.addComponent(button9);
        panel.addComponent(button10);

        JFrame.setDefaultLookAndFeelDecorated(true);

        // new Frame.
        Frame frame = new Frame("main frame", 600, 600, panel);

        // Image to Frame.
        frame.setIconImage(new ImageIcon("/Users/rustam/java/" +
                "tutorials_by_javabegin_ru/swing/icons/PNG/64x64/twitter.png").getImage());


    }
}
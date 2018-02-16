package ru.rmamedov.javabegin.swing.lesson_01_h;

import javax.swing.*;
import java.awt.*;

public class Start {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Fist app on Swing");
        jFrame.setSize(700, 700);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);

        jFrame.setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();
        jPanel.setSize(400, 400);
        jPanel.setBorder(BorderFactory.createEtchedBorder());
        jPanel.setVisible(true);
        jFrame.add(jPanel);

        JButton button1 = new JButton("button 1");
        JButton button2 = new JButton("button 2");
        JButton button3 = new JButton("button 3");
        button1.setSize(200, 100);
        button2.setSize(200, 100);
        button3.setSize(200, 100);
        jPanel.add(button1);
        jPanel.add(button2);
        jPanel.add(button3);

    }
}

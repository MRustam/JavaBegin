package ru.rmamedov.javabegin.gui;

import com.jtattoo.plaf.texture.TextureLookAndFeel;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new TextureLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Components.
        Button but1 = new Button("+");
        but1.setPreferredSize(new Dimension(85, 40));
        Button but2 = new Button("-");
        but2.setPreferredSize(new Dimension(85, 40));
        Button but3 = new Button("x");
        but3.setPreferredSize(new Dimension(85, 40));
        Button but4 = new Button("/");
        but4.setPreferredSize(new Dimension(85, 40));
        Button but5 = new Button("=");
        but5.setPreferredSize(new Dimension(85, 40));

        Text text1 = new Text(250, 50);
        text1.setPreferredSize(new Dimension(200, 40));
        Text text2 = new Text(250, 50);
        text2.setPreferredSize(new Dimension(200, 40));
        Text text3 = new Text(250, 50);
        text3.setPreferredSize(new Dimension(200, 40));

        Label label1 = new Label(": Num 1");
        Label label2 = new Label(": Num 2");
        Label label3 = new Label(": Result ");


        // Panel.
        Panel panel1 = new Panel();

        Panel panel1_1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        panel1_1.setBounds(10, 10, 270, 210);

        Panel panel2 = new Panel();
        Panel panel2_2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        panel2_2.setBounds(10, 10, 270, 210);


        panel1_1.add(text1);
        panel1_1.add(label1);
        panel1_1.add(but1);
        panel1_1.add(but2);
        panel1_1.add(but3);
        panel1_1.add(but4);
        panel1_1.add(text2);
        panel1_1.add(label2);
        panel1.add(panel1_1);

        panel2_2.add(text3);
        panel2_2.add(label3);
        panel2_2.add(but5);
        panel2.add(panel2_2);


        // Frame.
        Frame frame = new Frame("Calculator",
                600, 260, new GridLayout(1, 2, 2, 2));
        // Image to Frame.
        frame.setIconImage(new ImageIcon("/Users/rustam/java/" +
                "tutorials_by_javabegin_ru/swing/icons/PNG/64x64/twitter.png").getImage());
//        frame.setMaximumSize(new Dimension(600, 300));
//        frame.setMinimumSize(new Dimension(485, 255));
        frame.setResizable(false);

        JFrame.setDefaultLookAndFeelDecorated(true);

        frame.getContentPane().add(panel1);
        frame.getContentPane().add(panel2);

        frame.setVisible(true);
    }
}
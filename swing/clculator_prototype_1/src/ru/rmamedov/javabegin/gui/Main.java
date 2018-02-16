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

        Button button1 = new Button("+", 100, 50);
        Button button2 = new Button("-", 100, 50);
        Button button3 = new Button("x", 100, 50);
        Button button4 = new Button("/", 100, 50);
        Button button5 = new Button("=");
        button5.setPreferredSize(new Dimension(50, 100));

        Label label1 = new Label("Result :");
        label1.setHorizontalAlignment(JLabel.RIGHT);
        Label label2 = new Label("Num 1 :");
        label2.setHorizontalAlignment(JLabel.RIGHT);
        Label label3 = new Label("Num 2 :");
        label3.setHorizontalAlignment(JLabel.RIGHT);

        Text text1 = new Text();
        text1.setPreferredSize(new Dimension(200, 40));
        Text text2 = new Text();
        text2.setPreferredSize(new Dimension(200, 40));
        Text text3 = new Text();
        text3.setPreferredSize(new Dimension(200, 40));


        // Panel 1.
        Panel panel1 = new Panel(new FlowLayout(FlowLayout.LEFT, 10, 30));
        panel1.add(label2);
        panel1.add(text2);
        panel1.add(label3);
        panel1.add(text3);



        Panel panel2 = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 35));

        Panel panel2_2 = new Panel(new GridLayout(2, 2, 10, 10));
        panel2_2.setPreferredSize(new Dimension(200, 100));

        panel2_2.add(button1);
        panel2_2.add(button2);
        panel2_2.add(button3);
        panel2_2.add(button4);

        panel2.add(panel2_2);
        panel2.add(button5);


        Panel panelN = new Panel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        panelN.add(label1);
        panelN.add(text1);
        Panel panelS = new Panel(new GridLayout(1, 2));
        panelS.add(panel1);
        panelS.add(panel2);




        JFrame.setDefaultLookAndFeelDecorated(true);

        // new Frame.
        Frame frame = new Frame("Calculator", 650, 400, new GridLayout(2, 1));

        frame.setMinimumSize(new Dimension(650, 400));

        // Image to Frame.
        frame.setIconImage(new ImageIcon("/Users/rustam/java/" +
                "tutorials_by_javabegin_ru/swing/icons/PNG/64x64/twitter.png").getImage());

        frame.getContentPane().add(panelN);
        frame.getContentPane().add(panelS);

        frame.setResizable(false);
        frame.setVisible(true);
    }
}
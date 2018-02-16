package ru.rmamedov.javabegin.gui;

public class Main {

    public static void main(String[] args) {

        Button button1 = new Button("button 1", 100, 50);
        Button button2 = new Button("button 1", 100, 50);
        Button button3 = new Button("button 1", 100, 50);
        Panel panel = new Panel("panel 1", 400, 300, button1);
        panel.addComponent(button2);
        panel.addComponent(button3);
        Frame frame = new Frame("main frame", 600, 600, panel);

    }
}
package components;

import javax.swing.*;

public class MyButton extends JButton {

    public MyButton() {
    }

    public MyButton(String text) {
        super(text);
    }

    public MyButton(String text, int width, int height) {
        super(text);
        super.setSize(width, height);
    }
}
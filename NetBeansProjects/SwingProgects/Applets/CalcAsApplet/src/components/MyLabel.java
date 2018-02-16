package components;

import javax.swing.*;

public class MyLabel extends JLabel {

    public MyLabel() {

    }

    public MyLabel(String text) {
        super(text);
    }

    public MyLabel(String text, int width, int height) {
        super(text);
        super.setSize(width, height);
    }

}
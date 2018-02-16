package listeners;

import components.MyTextField;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MyFocusListener implements FocusListener {

    private MyTextField text;

    public MyFocusListener(MyTextField text) {
        this.text = text;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (text.getText().equals("input the number")) {
            text.setText("");
            text.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (text.getText().trim().equals("")) {
            text.setText("input the number");
            text.setForeground(Color.GRAY);
        }
    }
}
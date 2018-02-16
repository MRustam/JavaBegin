package components;

import javax.swing.*;

public class MyTextField extends JTextField {


    public MyTextField() {
        super.setHorizontalAlignment(JTextField.RIGHT);
    }

    public MyTextField(int width, int height) {
        super.setSize(width, height);
        super.setHorizontalAlignment(JTextField.RIGHT);
    }

    public MyTextField(String text, int width, int height) {
        super(text);
        super.setSize(width, height);
        super.setHorizontalAlignment(JTextField.RIGHT);
    }
}
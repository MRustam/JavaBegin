package listeners;

import components.MyButton;
import components.MyTextField;
import operations.Operation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

    private MyTextField text1;
    private MyTextField text2;
    private MyTextField textResult;

    public MyActionListener(MyTextField text1, MyTextField text2, MyTextField textResult) {
        this.text1 = text1;
        this.text2 = text2;
        this.textResult = textResult;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof MyButton) {

            MyButton butt = (MyButton) e.getSource();

            Double a = Double.parseDouble(text1.getText());
            Double b = Double.parseDouble(text2.getText());


            switch (butt.getText()) {
                case "+":
                    textResult.setText(String.valueOf(Operation.plus(a, b)));
                    break;

                case "-":
                    textResult.setText(String.valueOf(Operation.minus(a, b)));
                    break;

                case "x":
                    textResult.setText(String.valueOf(Operation.mult(a, b)));
                    break;

                case "/":
                    textResult.setText(String.valueOf(Operation.div(a, b)));
                    break;

                case "C":
                    textResult.setText("");
                    text1.setText("");
                    text2.setText("");
                    break;
            }
        }
    }
}
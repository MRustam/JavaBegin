package start;

import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import components.*;
import listeners.*;

import javax.swing.*;
import java.awt.*;

public class StartUI {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new TextureLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Frame.
        MyFrame frame = new MyFrame("Calculator",
                600, 260, new GridLayout(1, 2, 2, 2));
        frame.setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);

        
        // Create operations buttons.
        MyButton butt1 = new MyButton("+");
        butt1.setPreferredSize(new Dimension(85, 40));

        MyButton butt2 = new MyButton("-");
        butt2.setPreferredSize(new Dimension(85, 40));

        MyButton butt3 = new MyButton("x");
        butt3.setPreferredSize(new Dimension(85, 40));

        MyButton butt4 = new MyButton("/");
        butt4.setPreferredSize(new Dimension(85, 40));

        MyButton butt5 = new MyButton("C");
        butt5.setPreferredSize(new Dimension(40, 40));

        // Create Skin buttons.
        // 1.
        MyButton skin1 = new MyButton("skin 1");
        skin1.setPreferredSize(new Dimension(60, 40));
        skin1.addActionListener(new MySkinListener(frame, new TextureLookAndFeel()));
        // 2.
        MyButton skin2 = new MyButton("skin 2");
        skin2.setPreferredSize(new Dimension(60, 40));
        skin2.addActionListener(new MySkinListener(frame, new HiFiLookAndFeel()));
        // 3.
        MyButton skin3 = new MyButton("skin 3");
        skin3.setPreferredSize(new Dimension(60, 40));
        skin3.addActionListener(new MySkinListener(frame, new AluminiumLookAndFeel()));

        // Text 1.
        MyTextField text1 = new MyTextField(250, 50);
        text1.setPreferredSize(new Dimension(200, 40));
        // Text 2.
        MyTextField text2 = new MyTextField(250, 50);
        text2.setPreferredSize(new Dimension(200, 40));
        // Text Result.
        MyTextField textResult = new MyTextField(250, 50);
        textResult.setPreferredSize(new Dimension(200, 40));
        textResult.setEditable(false);

        // Create Listener.
        MyActionListener listener = new MyActionListener(text1, text2, textResult);

        // Add FocusListener to textField.
        text1.addFocusListener(new MyFocusListener(text1));
        text2.addFocusListener(new MyFocusListener(text2));

        // Create KeyListener.
        MyKeyListener keyListener = new MyKeyListener();
        text1.addKeyListener(keyListener);
        text2.addKeyListener(keyListener);

        // Add ActionListener.
        butt1.addActionListener(listener);
        butt2.addActionListener(listener);
        butt3.addActionListener(listener);
        butt4.addActionListener(listener);
        butt5.addActionListener(listener);

        // Create Label.
        MyLabel label1 = new MyLabel(": Num 1");
        MyLabel label2 = new MyLabel(": Num 2");
        MyLabel label3 = new MyLabel(": Result ");

        // Create Panel.
        MyPanel panel1 = new MyPanel();
        // 1.
        MyPanel panel1_1 = new MyPanel(new FlowLayout(FlowLayout.LEFT));
        panel1_1.setBounds(10, 10, 270, 210);
        // 2.
        MyPanel panel2 = new MyPanel();
        // 2.2.
        MyPanel panel2_2 = new MyPanel(new FlowLayout(FlowLayout.LEFT));
        panel2_2.setBounds(10, 10, 270, 210);
        // 2.3.
        MyPanel panel2_3 = new MyPanel();
        BoxLayout b = new BoxLayout(panel2_3, BoxLayout.Y_AXIS);
        panel2_3.setLayout(b);
        // Add to panel 1.1.
        panel1_1.add(text1);
        panel1_1.add(label1);
        panel1_1.add(butt1);
        panel1_1.add(butt2);
        panel1_1.add(butt5);
        panel1_1.add(butt3);
        panel1_1.add(butt4);
        panel1_1.add(text2);
        panel1_1.add(label2);
        // Add to panel 1.
        panel1.add(panel1_1);
        // Add to panel 2.3.
        panel2_3.add(skin1);
        panel2_3.add(skin2);
        panel2_3.add(skin3);
        // Add to panel 2.2.
        panel2_2.add(textResult);
        panel2_2.add(label3);
        panel2_2.add(panel2_3);
        // Add to panel 2.
        panel2.add(panel2_2);

        frame.getContentPane().add(panel1);
        frame.getContentPane().add(panel2);

        frame.setVisible(true);
    }
}

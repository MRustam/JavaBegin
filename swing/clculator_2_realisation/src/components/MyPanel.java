package components;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    public MyPanel() {
        super.setLayout(null);
        //super.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    public MyPanel(LayoutManager layoutManager) {
        super.setLayout(layoutManager);
        super.setBorder(BorderFactory.createRaisedBevelBorder());
    }


    public MyPanel(int width, int height) {
        super.setSize(width, height);
        super.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    public MyPanel(int width, int height, LayoutManager layoutManager) {
        this(width, height);
        super.setBorder(BorderFactory.createRaisedBevelBorder());
        super.setLayout(layoutManager);
    }
}
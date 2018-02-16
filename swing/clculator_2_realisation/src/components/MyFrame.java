package components;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
    }

    public MyFrame(String title) throws HeadlessException {
        super(title);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
    }


    public MyFrame (String title, int width, int height) {
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
    }

    public MyFrame (String title, int width, int height, LayoutManager layoutManager) {
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        super.setLayout(null);
        super.setLayout(layoutManager);
        super.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
    }
}
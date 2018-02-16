package listeners;

import components.MyFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySkinListener implements ActionListener {

    private MyFrame frame;
    private LookAndFeel laf;

    public MySkinListener(MyFrame frame, LookAndFeel laf) {
        this.frame = frame;
        this.laf = laf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(frame);
    }
}
package ru.rmamedovjtablefromarray;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableFromArray {

    public static void main(String[] args) {

        Object[] columnHeaders = {"Фамилия", "Имя", "Отчество", "email"};
        Object[][] tableData = {
            {"Иванов", "Иван", "Иванович", "test1@mail.ru"},
            {"Петров", "Олег", "Петрович", "test2@mail.ru"},
            {"Алексеев", "Алексей", "Алексеевич", "test3@mail.ru"},
            {"Сидоров", "Сидор", "Сидорович", "test4@mail.ru"},
            {"Олегов", "Олег", "Олегович", "test5@mail.ru"}
        };

        JFrame frame = new JFrame("Exemple data from array");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTable table = new JTable(tableData, columnHeaders);
        table.setRowHeight(30);

        table.setDefaultRenderer(Object.class, new MyTableRenderer());

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();
                    String value = target.getValueAt(target.getSelectedRow(),
                            target.getSelectedColumn()).toString();
                    try {

                        if (value.contains("@")) {
                            Desktop.getDesktop().mail(new URI("mailto:" + value
                                    + "?SUBJECT=Служебное%20письмо&body=Текст%20письма"));
                        }

                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            }

        });

        table.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                JTable target = (JTable)e.getSource();
                if (target.columnAtPoint(e.getPoint()) == 3) {
                    target.setCursor(new Cursor(Cursor.HAND_CURSOR));
                } else {
                    target.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }
            
        });
        
        JScrollPane scrolPane = new JScrollPane(table);
        
        table.setPreferredScrollableViewportSize(new Dimension(400, 200));
        
        frame.getContentPane().add(scrolPane);
        frame.setVisible(true);

    }

}

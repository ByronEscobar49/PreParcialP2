package org.example.Formularios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMenu extends JFrame{
    private JPanel frmMenu;
    private JLabel menu;
    private JButton buttondatos;
    private JButton buttonBot;
    private JButton buttonChampions;


   public frmMenu() {
//        setTitle("Formulario Principal - Menu");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);



        buttonChampions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmChampionsLeague frmChampionsLeague = new frmChampionsLeague();
                frmChampionsLeague.setVisible(true);
            }
        });

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("frmMenu");
        frame.setContentPane(new frmMenu().frmMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

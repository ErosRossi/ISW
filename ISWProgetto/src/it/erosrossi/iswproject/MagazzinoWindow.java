package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MagazzinoWindow extends JFrame {
    private static final JButton home = new JButton("home");


    public MagazzinoWindow(  )
    {

        final JFrame magazzino = new JFrame("Magazzino"); // Creo la finestra per l'autenticazione.
        magazzino.setSize(600, 500);
        magazzino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container magazzinoContainer = magazzino.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        magazzinoContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL; // Non so come mai ma lasciamolo.


        magazzinoContainer.add(new JLabel("benvenuto nella sezione dedicata al magazzino"));
        magazzino.setVisible(true);

        c.gridx = 2;
        c.gridy = 1;
        gridbag.setConstraints(home, c);
        magazzinoContainer.add(home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginWindow();
                magazzino.setVisible(false);
                }
            });

    }
}

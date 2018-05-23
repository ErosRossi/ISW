package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class NegozioWindow extends JFrame {
    private static final JButton home = new JButton("home");


    public NegozioWindow(  )
    {

        final JFrame negozio = new JFrame("Negozio"); // Creo la finestra per l'autenticazione.
        negozio.setSize(600, 500);
        negozio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container negozioContainer = negozio.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        negozioContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL; // Non so come mai ma lasciamolo.


        negozioContainer.add(new JLabel("benvenuto nella sezione dedicata ai negozi"));
        negozio.setVisible(true);

        c.gridx = 2;
        c.gridy = 1;
        gridbag.setConstraints(home, c);
        negozioContainer.add(home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginWindow();
                negozio.setVisible(false);
            }
        });


    }
}

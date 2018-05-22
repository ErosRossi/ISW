package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class SegreteriaWindow extends JFrame {
    private static final JButton oks = new JButton("OK");


    public SegreteriaWindow(  )
    {

        JFrame login = new JFrame("Finestra di login"); // Creo la finestra per l'autenticazione.
        login.setSize(600, 500);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container loginContainer = login.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        loginContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL; // Non so come mai ma lasciamolo.

        JLabel testoUtente = new JLabel("Riccardo: "); // Stringa
        c.gridx = 0;
        c.gridy = 0;
        gridbag.setConstraints(testoUtente, c);
        loginContainer.add(testoUtente);

        JTextField testo = new JTextField(10); // Casella di testo
        c.gridx = 1;
        c.gridy = 0;
        gridbag.setConstraints(testo, c);
        loginContainer.add(testo);

        JLabel testoPW = new JLabel("Eros: ");
        c.gridx = 0;
        c.gridy = 1;
        gridbag.setConstraints(testoPW, c);
        loginContainer.add(testoPW);

        JPasswordField pw = new JPasswordField(); // Casella a caratteri nascosti per la PW.
        c.gridx = 1;
        c.gridy = 1;
        gridbag.setConstraints(pw, c);
        loginContainer.add(pw);

        c.gridx = 2;
        c.gridy = 1;
        gridbag.setConstraints(oks, c);
        loginContainer.add(oks);

        login.setVisible(true);
    }
}

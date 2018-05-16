package it.erosrossi.iswproject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 * Finestra iniziale di login nell'applicazione.
 *
 * @author Rossi Eros
 */
public class LoginWindow extends JFrame implements Observer {

    private static final JButton ok = new JButton("OK");
    public String pass;
    public String nome;

    public LoginWindow(  )
    {

        JFrame login = new JFrame("Finestra di login"); // Creo la finestra per l'autenticazione.
        login.setSize(600, 500);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container loginContainer = login.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        loginContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL; // Non so come mai ma lasciamolo.

        JLabel testoUtente = new JLabel("Inserisci nome utente: "); // Stringa
        c.gridx = 0;
        c.gridy = 0;
        gridbag.setConstraints(testoUtente, c);
        loginContainer.add(testoUtente);

        JTextField testo = new JTextField(10); // Casella di testo
        c.gridx = 1;
        c.gridy = 0;
        gridbag.setConstraints(testo, c);
        loginContainer.add(testo);

        JLabel testoPW = new JLabel("Inserisci la PW: ");
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
        gridbag.setConstraints(ok, c);
        loginContainer.add(ok);
        ok.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pass = new String(pw.getPassword());
                nome = new String(testo.getText()); // Fare un metodo di per il controllo e dentro questo evento far partire la seconda interfaccia.
                System.out.println(nome);
                System.out.println(pass);
                //check = metodo();


            }
        });


        login.setVisible(true);
    }
}


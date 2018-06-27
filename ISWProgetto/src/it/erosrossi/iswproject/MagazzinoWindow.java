package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MagazzinoWindow extends JFrame {
    // Bottone per il ritorno alla home
    private static final JButton home = new JButton("Home");
    // Bottone per la visualizzazione degli ordini
    private static final JButton ordini = new JButton("Controllo Ordini");
    // Bottone per la visualizzazione degli ordini
    private static final JButton modificaPosizione = new JButton("Modifica Disposizione");


    public MagazzinoWindow(  )
    {

        final JFrame magazzino = new JFrame("Magazzino"); // Inizializzo la finestra con un titolo.
        magazzino.setSize(600, 500);
        magazzino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container magazzinoContainer = magazzino.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        magazzinoContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();
        //c.fill = GridBagConstraints.HORIZONTAL; // Non so come mai ma lasciamolo.

        // Inserimento del testo iniziale.
        JLabel testoMagazzino = new JLabel("Seleziona quale operazione eseguire: ");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        gridbag.setConstraints( testoMagazzino, c );
        magazzinoContainer.add( testoMagazzino );

        // Inserimento riga vuota
        JLabel testoVuoto = new JLabel(" ");
        c.gridx = 0;
        c.gridy = 1;
        gridbag.setConstraints( testoVuoto, c );
        magazzinoContainer.add( testoVuoto );

        // Tasto per gestione ordini
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LINE_END;
        gridbag.setConstraints(ordini, c);
        magazzinoContainer.add(ordini);
        ordini.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginWindow();
                magazzino.dispose();
                magazzino.setVisible(false);
            }
        });

        // Tasto per modifica posizione
        c.gridx = 1;
        c.gridy = 3;
        gridbag.setConstraints(modificaPosizione, c);
        magazzinoContainer.add(modificaPosizione);
        modificaPosizione.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MagazzinoModificaPosizione();
                magazzino.dispose();
                magazzino.setVisible(false);
            }
        });

        // Tasto per tornare alla home
        c.gridx = 2;
        c.gridy = 3;
        gridbag.setConstraints(home, c);
        magazzinoContainer.add(home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginWindow();
                magazzino.dispose();
                magazzino.setVisible(false);
                }
            });

        magazzino.setVisible(true); // Rendo la finestra visibile, sempre mettere in fondo al metodo.

    }
}

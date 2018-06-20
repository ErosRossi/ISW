package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MagazzinoModificaPosizione extends JFrame {
    // Bottone per il ritorno alla home
    private static final JButton home = new JButton("Home");
    // Bottone per il ritorno alla home
    private static final JButton aggiorna = new JButton("Aggiorna");

    // Da implementare metodo di ricerca su file e modifica posizione.

    public MagazzinoModificaPosizione(  )
    {

        final JFrame modificaPosizione = new JFrame("Modifica Posizione"); // Inizializzo la finestra con un titolo.
        modificaPosizione.setSize(600, 500);
        modificaPosizione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container magazzinoModPosizioneContainer = modificaPosizione.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        magazzinoModPosizioneContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();

        // Testo per id oggetto
        JLabel testoID = new JLabel("Inserisci codice oggetto: ");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        gridbag.setConstraints( testoID, c );
        magazzinoModPosizioneContainer.add( testoID );

        // Casella di inserimento codice oggetto
        final JTextField codice = new JTextField(10); // Casella di testo
        c.gridx = 1;
        c.gridy = 0;
        gridbag.setConstraints(codice, c);
        magazzinoModPosizioneContainer.add(codice);

        // Testo nuova posizione
        JLabel testoPosizione = new JLabel("Inserisci la nuova posizione: ");
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        gridbag.setConstraints( testoPosizione, c );
        magazzinoModPosizioneContainer.add( testoPosizione );

        // Casella di inserimento nuova posizione
        final JTextField nuovaPosizione = new JTextField(10); // Casella di testo
        c.gridx = 1;
        c.gridy = 1;
        gridbag.setConstraints(nuovaPosizione, c);
        magazzinoModPosizioneContainer.add(nuovaPosizione);

        //Inserimento riga vuota
        JLabel testoVuoto = new JLabel(" ");
        c.gridx = 0;
        c.gridy = 2;
        gridbag.setConstraints( testoVuoto, c );
        magazzinoModPosizioneContainer.add( testoVuoto );

        // Tasto per aggiornare la posizione
        c.gridx = 0;
        c.gridy = 3;
        gridbag.setConstraints(aggiorna, c);
        magazzinoModPosizioneContainer.add(aggiorna);
        aggiorna.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Codice da inserire
            }
        });

        c.gridx = 1;
        c.gridy = 3;
        gridbag.setConstraints(home, c);
        magazzinoModPosizioneContainer.add(home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginWindow();
                modificaPosizione.setVisible(false);
            }
        });

        modificaPosizione.setVisible(true);

    }
}

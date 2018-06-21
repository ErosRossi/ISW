package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class SegreteriaWindow extends JFrame {
    private static final JButton home = new JButton("Home"); // Bottone per la home
    private static final JButton inserimento = new JButton("Inserisci nuovo articolo"); // Bottone per inserimento articolo
    private static final JButton movMagazzino = new JButton("Visualizza movimenti del magazzino"); // Bottone per visualizzare i movimenti del magazzino


    public SegreteriaWindow(  )
    {

        JFrame segreteria = new JFrame("Segreteria"); // Creo la finestra.
        segreteria.setSize(600, 500);
        segreteria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container segreteriaContainer = segreteria.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        segreteriaContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();

        // Inserimento del testo iniziale.
        JLabel testoSegreteria = new JLabel("Seleziona quale operazione eseguire: ");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        gridbag.setConstraints( testoSegreteria, c );
        segreteriaContainer.add( testoSegreteria );

        // Inserimento riga vuota
        JLabel testoVuoto = new JLabel(" ");
        c.gridx = 0;
        c.gridy = 1;
        gridbag.setConstraints( testoVuoto, c );
        segreteriaContainer.add( testoVuoto );

        // Tasto per inserimento articoli
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LINE_END;
        gridbag.setConstraints(inserimento, c);
        segreteriaContainer.add(inserimento);
        inserimento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new InserimentoArticoliSegreteria();
                segreteria.setVisible(false);
            }
        });

        // Tasto per visualizzazione ordini
        c.gridx = 1;
        c.gridy = 3;
        gridbag.setConstraints(movMagazzino, c);
        segreteriaContainer.add(movMagazzino);
        segreteriaContainer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Codice da inserire
                segreteria.setVisible(false);
            }
        });

        // Tasto per tornare alla home
        c.gridx = 2;
        c.gridy = 3;
        gridbag.setConstraints(home, c);
        segreteriaContainer.add(home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginWindow();
                segreteria.setVisible(false);
            }
        });

        segreteria.setVisible(true);
    }
}

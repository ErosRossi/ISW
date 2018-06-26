package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class NegozioWindow extends JFrame {
    private static final JButton home = new JButton("Home"); // Bottone per la home
    private static final JButton inserimento = new JButton("Inserisci nuovo ordine"); // Bottone per inserimento articolo
    private static final JButton ordiniPassati = new JButton("Visualizza ordini"); // Bottone per visualizzare i movimenti del magazzino

    public NegozioWindow(  )
    {

        JFrame negozio = new JFrame("Negozio"); // Creo la finestra.
        negozio.setSize(600, 500);
        negozio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container negozioContainer = negozio.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        negozioContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();

        // Inserimento del testo iniziale.
        JLabel testoSegreteria = new JLabel("Seleziona quale operazione eseguire: ");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        gridbag.setConstraints( testoSegreteria, c );
        negozioContainer.add( testoSegreteria );

        // Inserimento riga vuota
        JLabel testoVuoto = new JLabel(" ");
        c.gridx = 0;
        c.gridy = 1;
        gridbag.setConstraints( testoVuoto, c );
        negozioContainer.add( testoVuoto );

        // Tasto per inserimento articoli
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LINE_END;
        gridbag.setConstraints(inserimento, c);
        negozioContainer.add(inserimento);
        inserimento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //new InserimentoArticoliSegreteria();
                negozio.setVisible(false);
            }
        });

        // Tasto per visualizzazione ordini
        c.gridx = 1;
        c.gridy = 3;
        gridbag.setConstraints(ordiniPassati, c);
        negozioContainer.add(ordiniPassati);
        ordiniPassati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Codice da inserire
                new OrdiniPassatiNegozio();
                negozio.setVisible(false);
            }
        });

        // Tasto per tornare alla home
        c.gridx = 2;
        c.gridy = 3;
        gridbag.setConstraints(home, c);
        negozioContainer.add(home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginWindow();
                negozio.setVisible(false);
            }
        });

        negozio.setVisible(true);

    }
}

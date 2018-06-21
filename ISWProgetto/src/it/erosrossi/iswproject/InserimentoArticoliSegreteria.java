package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class InserimentoArticoliSegreteria extends JFrame {
    private static final JButton home = new JButton("Home Segreteria");

    private static final JButton conferma = new JButton("Conferma");

    public int contaCampiVuoti = 0;

    public void ContaVuoti( String daControllare )
    {
        daControllare = daControllare.trim(); // Sovrascrivo la stringa eliminando gli spazi
        
        if( daControllare.isEmpty() ) {
            contaCampiVuoti = 1;
        }
    }

    public InserimentoArticoliSegreteria(  )
    {

        // contaCampiVuoti = 0;

        String s = new String();

        JFrame inserimentoArticoli = new JFrame("Inserimento Articoli"); // Creo la finestra.
        inserimentoArticoli.setSize(600, 500);
        inserimentoArticoli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container inserimentoArticoliContainer = inserimentoArticoli.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        inserimentoArticoliContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();



        // Testo per inserimento sport.
        JLabel testoSport = new JLabel("Inserisci lo sport: ");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        gridbag.setConstraints( testoSport, c );
        inserimentoArticoliContainer.add(testoSport);

        // Campo inserimento sport.
        final JTextField sport = new JTextField( 10 ); // Necessario usare getText per recuperare quello che é scritto dentro.
        c.gridx = 1;
        c.gridy = 0;
        gridbag.setConstraints( sport, c );
        inserimentoArticoliContainer.add(sport);



        // Testo per inserimento tipo articolo.
        JLabel testoTipo = new JLabel("Inserisci il tipo di articolo: ");
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        gridbag.setConstraints( testoTipo, c );
        inserimentoArticoliContainer.add(testoTipo);

        // Campo inserimento sport.
        JTextField tipo = new JTextField( 10 ); // Necessario usare getText per recuperare quello che é scritto dentro.
        c.gridx = 1;
        c.gridy = 1;
        gridbag.setConstraints( tipo, c );
        inserimentoArticoliContainer.add(tipo);



        // Testo per inserimento materiale.
        JLabel testoMateriale = new JLabel("Inserisci il materiale dell' articolo: ");
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_START;
        gridbag.setConstraints( testoMateriale, c );
        inserimentoArticoliContainer.add(testoMateriale);

        // Campo inserimento materiale.
        JTextField materiale = new JTextField( 10 ); // Necessario usare getText per recuperare quello che é scritto dentro.
        c.gridx = 1;
        c.gridy = 2;
        gridbag.setConstraints( materiale, c );
        inserimentoArticoliContainer.add(materiale);



        // Testo per inserimento taglia.
        JLabel testoTaglia = new JLabel("Inserisci la taglia: ");
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LINE_START;
        gridbag.setConstraints( testoTaglia, c );
        inserimentoArticoliContainer.add(testoTaglia);

        // Campo inserimento taglia.
        JTextField taglia = new JTextField( 10 ); // Necessario usare getText per recuperare quello che é scritto dentro.
        c.gridx = 1;
        c.gridy = 3;
        gridbag.setConstraints( taglia, c );
        inserimentoArticoliContainer.add(taglia);



        // Testo per inserimento colore articolo.
        JLabel testoColore = new JLabel("Inserisci il colore dell' articolo: ");
        c.gridx = 0;
        c.gridy = 4;
        c.anchor = GridBagConstraints.LINE_START;
        gridbag.setConstraints( testoColore, c );
        inserimentoArticoliContainer.add(testoColore);

        // Campo inserimento colore.
        JTextField colore = new JTextField( 10 ); // Necessario usare getText per recuperare quello che é scritto dentro.
        c.gridx = 1;
        c.gridy = 4;
        gridbag.setConstraints( colore, c );
        inserimentoArticoliContainer.add(colore);



        // Tasto per confermare l'inserimento.
        c.gridx = 0;
        c.gridy = 5;
        c.anchor = GridBagConstraints.LINE_START;
        gridbag.setConstraints(conferma, c);
        inserimentoArticoliContainer.add(conferma);
        conferma.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                ContaVuoti( new String(sport.getText()) );
                ContaVuoti( new String(tipo.getText()) );
                ContaVuoti( new String(materiale.getText()) );
                ContaVuoti( new String(taglia.getText()) );
                ContaVuoti( new String(colore.getText()) );

                if( contaCampiVuoti != 0 )
                {
                    new PopUpWindow( 1 );
                }

                inserimentoArticoli.setVisible(false);

            }
        });



        // Tasto home che ritorna alla home della Segreteria.
        c.gridx = 1;
        c.gridy = 5;
        c.anchor = GridBagConstraints.LINE_START;
        gridbag.setConstraints(home, c);
        inserimentoArticoliContainer.add(home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SegreteriaWindow();
                inserimentoArticoli.setVisible(false);
            }
        });

        inserimentoArticoli.setVisible(true);
    }
}

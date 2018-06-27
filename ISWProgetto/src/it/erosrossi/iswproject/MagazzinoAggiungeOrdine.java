package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;

public class MagazzinoAggiungeOrdine {

    private static final JButton home = new JButton("Home Magazzino");
    private static final JButton aggiungi = new JButton("Aggiungi");

    public Vector<String> numBolle = new Vector<String>();
    public Vector<String> prodotti = new Vector<String>();
    public Vector<String> negozio = new Vector<String>();

    public void getBolle() throws IOException {

        FileReader fr = new FileReader("Ordini.txt");
        BufferedReader br = new BufferedReader(fr);

        String in = new String();

        while ( ( in = br.readLine() ) != null ) {

            String[] strArray = in.split("/");
            if( strArray[6].equals("0") )
            {
                numBolle.add(strArray[0]);
                prodotti.add(strArray[3]);
                negozio.add(strArray[2]);
            }

        }

        br.close();
    }

    public MagazzinoAggiungeOrdine()
    {
        final JFrame magazzinoAddOrdine = new JFrame("Magazzino"); // Inizializzo la finestra con un titolo.
        magazzinoAddOrdine.setSize(600, 500);
        magazzinoAddOrdine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container magazzinoAddOrdineContainer = magazzinoAddOrdine.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        magazzinoAddOrdineContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();

        try {
            getBolle();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JComboBox listaBolle = new JComboBox(numBolle); // Menú a tendina degli ordini inviabili
        listaBolle.setSelectedIndex(4);
        c.gridx = 0;
        c.gridy = 0;
        gridbag.setConstraints( listaBolle, c );
        magazzinoAddOrdineContainer.add( listaBolle );

        JLabel testoCorriere = new JLabel("Inserisci il nome del corriere:");
        c.gridx = 0;
        c.gridy = 1;
        gridbag.setConstraints( testoCorriere, c );
        magazzinoAddOrdineContainer.add( testoCorriere );

        JTextField nomeCorriere = new JTextField(10 );
        c.gridx = 1;
        c.gridy = 1;
        gridbag.setConstraints( nomeCorriere, c );
        magazzinoAddOrdineContainer.add( nomeCorriere );


        c.gridx = 0;
        c.gridy = 2;
        gridbag.setConstraints( aggiungi, c );
        magazzinoAddOrdine.add( aggiungi );
        aggiungi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Inserire codice per aggiunta ordine.
                new PopUpWindow(5);
                magazzinoAddOrdine.dispose();
                magazzinoAddOrdine.setVisible(false);
            }
        });

        c.gridx = 1;
        c.gridy = 2;
        gridbag.setConstraints( home, c );
        magazzinoAddOrdineContainer.add( home );
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MagazzinoWindow();
                magazzinoAddOrdine.dispose();
                magazzinoAddOrdine.setVisible(false);
            }
        });


        magazzinoAddOrdine.setVisible(true);
    }
}

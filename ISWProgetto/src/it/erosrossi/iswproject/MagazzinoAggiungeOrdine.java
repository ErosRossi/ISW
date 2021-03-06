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

    public void getBolle() throws IOException {

        FileReader fr = new FileReader("Ordini.txt");
        BufferedReader br = new BufferedReader(fr);

        String in = new String();

        while ( ( in = br.readLine() ) != null ) {

            String[] strArray = in.split("/");

            if( strArray[6].equals("0") )
            {
                numBolle.add(strArray[0]);
            }

        }

        br.close();
    }

    // Metodo per l'aggiunta degli ordini.
    public void AggiungiOrdine(String corriere , String bolla) throws IOException {

        FileReader fr = new FileReader("Ordini.txt");
        BufferedReader br = new BufferedReader(fr);

        String in = new String();
        String prodotti = new String();
        String negozio = new String();

        while ( ( in = br.readLine() ) != null ) {

            String[] strArray = in.split("/");

            if( strArray[0].equals(bolla) )
            {
                negozio = strArray[2];
                prodotti = strArray[3];
            }

        }

        br.close();

        String tmp = new String();
        tmp = bolla+"/02 Lug 2018"+"/"+negozio+"/"+prodotti+"/"+corriere+"\n";

        FileWriter fw = new FileWriter("MagazzinoOUT.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter outFile = new PrintWriter (bw);
        outFile.write(tmp);
                //in=in.substring(0, in.length()-2)+posizione+"\n";
        outFile.close();
        fw.close();
        bw.close();

        riscriviOrdini( bolla );
    }

    public void riscriviOrdini( String bolla ) throws IOException {
        Vector<String> memo = new Vector<String>();

        FileReader fr = new FileReader("Ordini.txt");
        BufferedReader br = new BufferedReader(fr);

        String in = new String();

        while ( ( in = br.readLine() ) != null ) {

            String[] strArray = in.split("/");

            if( strArray[0].equals(bolla) )
            {
                String tmp = new String();
                tmp = strArray[0]+"/"+strArray[1]+"/"+strArray[2]+"/"+strArray[3]+"/"+strArray[4]+"/"+strArray[5]+"/1";
                memo.add(tmp);
            }
            else
            {
                memo.add(in);
            }

        }

        br.close();

        FileWriter fw = new FileWriter("Ordini.txt",false);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter outFile = new PrintWriter (bw);
        //outFile.write(tmp);

        for( int i = 0; i < memo.size() ; i++ )
        {
            outFile.println( memo.get(i) );
        }
        //in=in.substring(0, in.length()-2)+posizione+"\n";
        outFile.close();
        fw.close();
        bw.close();


        }

    public int checkslash(String s){

        if(s.contains("/")) {
            return 0;
        }

        return 1;
    }

    public int contaCampiVuoti = 0;
    public void ContaVuoti( String daControllare )
    {
        daControllare = daControllare.trim(); // Sovrascrivo la stringa eliminando gli spazi

        if( daControllare.isEmpty() ) {
            contaCampiVuoti = 1;
        }
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


        JLabel testoSelezioneBolla = new JLabel("Seleziona la bolla dell'ordine");
        c.gridx = 0;
        c.gridy = 0;
        gridbag.setConstraints( testoSelezioneBolla, c );
        magazzinoAddOrdineContainer.add( testoSelezioneBolla );


        JComboBox listaBolle = new JComboBox(numBolle); // Menú a tendina degli ordini inviabili
        //listaBolle.setSelectedIndex(4);
        c.gridx = 1;
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
                String nomecorriere = nomeCorriere.getText();
                ContaVuoti( new String(nomeCorriere.getText()) );

                if ((contaCampiVuoti==0)&& (checkslash(nomecorriere) == 1)) {
                    try {
                        AggiungiOrdine(nomecorriere, (String) listaBolle.getSelectedItem());
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    new PopUpWindow(5);
                    magazzinoAddOrdine.dispose();
                    magazzinoAddOrdine.setVisible(false);

                } else {
                    new PopUpWindow(8);
                    magazzinoAddOrdine.dispose();
                    magazzinoAddOrdine.setVisible(false);
                }
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

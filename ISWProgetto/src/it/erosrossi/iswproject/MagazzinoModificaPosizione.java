package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class MagazzinoModificaPosizione extends JFrame {
    // Bottone per il ritorno alla home
    private static final JButton home = new JButton("Home Magazzino");
    // Bottone per il ritorno alla home
    private static final JButton aggiorna = new JButton("Aggiorna");

    // Da implementare metodo di ricerca su file e modifica posizione.
    public int Check (String s) throws IOException {

        FileReader fr = new FileReader("Articoli.txt");
        BufferedReader br = new BufferedReader(fr);

        String in = new String();

        while ( ( in = br.readLine() ) != null ) {

            String[] strArray = in.split("/");

            if( strArray[0].equals(s) )
            {
                return 1;
            }
        }

        br.close();

        return 0;
    }

    public void AggiornaPos(String codice , String posizione) throws IOException {

        FileReader fr = new FileReader("Articoli.txt");
        BufferedReader br = new BufferedReader(fr);

        String in = new String();

        Vector<String> array = new Vector<String>();

        while ( ( in = br.readLine() ) != null ) {

            String[] strArray = in.split("/");

                if (strArray[0].equals(codice)) {
                    String tmp = new String();
                    tmp = strArray[0] + "/" + strArray[1] + "/" + strArray[2] + "/" + strArray[3] + "/" + strArray[4] + "/" + posizione ;
                    array.add(tmp);

                }
                else {
                    array.add(in);
                }
        }

        br.close();


        FileWriter fw = new FileWriter("Articoli.txt", false);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter outFile = new PrintWriter(bw);

        for( int i = 0; i < array.size() ; i++ )
        {
            outFile.println( array.get(i) );
        }

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

                String pos = nuovaPosizione.getText();
                String cod = codice.getText();
                try {
                    int flag = Check( cod );

                    if( flag == 1 )
                    {
                        if ((contaCampiVuoti==0) && ((checkslash(pos)==1 ))){
                            AggiornaPos(cod,pos);
                            new PopUpWindow(4); // Inserimento corretto
                            modificaPosizione.dispose();
                            modificaPosizione.setVisible(false);
                        }
                        else{

                        new PopUpWindow(3); // Inserimento errato
                        modificaPosizione.dispose();
                        modificaPosizione.setVisible(false);

                        }
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });

        c.gridx = 1;
        c.gridy = 3;
        gridbag.setConstraints(home, c);
        magazzinoModPosizioneContainer.add(home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MagazzinoWindow();
                modificaPosizione.dispose();
                modificaPosizione.setVisible(false);
            }
        });

        modificaPosizione.setVisible(true);

    }
}



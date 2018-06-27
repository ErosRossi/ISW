package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class MagazzinoModificaPosizione extends JFrame {
    // Bottone per il ritorno alla home
    private static final JButton home = new JButton("Home");
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
        String tmp = new String();
        while ( ( in = br.readLine() ) != null )  {

            String[] strArray = in.split("/");

            if( strArray[0].equals(codice) )
            {

                tmp = strArray[0]+"/"+strArray[1]+"/"+strArray[2]+"/"+strArray[3]+"/"+strArray[4]+"/"+posizione+"\n";

                FileWriter fw = new FileWriter("Articoli.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter outFile = new PrintWriter (bw);
                outFile.write(tmp);
                //in=in.substring(0, in.length()-2)+posizione+"\n";
                outFile.close();
                fw.flush();
                fw.close();
                bw.close();
            }
        }

        br.close();
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
                try {
                    int flag = Check( codice.getText() );

                    if( flag == 1 )
                    {
                        AggiornaPos(codice.getText(),nuovaPosizione.getText());
                    }
                    else
                    {
                        // Metodo popUp per errore.
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
                new LoginWindow();
                modificaPosizione.setVisible(false);
            }
        });

        modificaPosizione.setVisible(true);

    }
}



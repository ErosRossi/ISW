package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class NegozioInserisceOrdine {

    private static final JButton conferma = new JButton("Conferma");
    private static final JButton home = new JButton("Home Negozio");

    public int contaCampiVuoti = 0;

    public void ContaVuoti( String daControllare )
    {
        daControllare = daControllare.trim(); // Sovrascrivo la stringa eliminando gli spazi

        if( daControllare.isEmpty() ) {
            contaCampiVuoti = 1;
        }
    }

    public void writeFile(String s) throws IOException {

            FileWriter fw = new FileWriter("Ordini.txt", true);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter outFile = new PrintWriter (bw);

            outFile.write(s);
            outFile.close();
            //fw.flush();
            fw.close();
    }

    public int checkslash(String s){

        if(s.contains("/")) {
            return 0;
        }

        return 1;
    }

    public NegozioInserisceOrdine(){

        JFrame inserimentoOrdine = new JFrame("Inserimento Ordini"); // Creo la finestra.
        inserimentoOrdine.setSize(600, 500);
        inserimentoOrdine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container inserimentoOrdineContainer = inserimentoOrdine.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        inserimentoOrdineContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();



        // Testo per inserimento articoli.
        JLabel testoArticoli = new JLabel("Inserisci gli articoli: ");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        gridbag.setConstraints( testoArticoli, c );
        inserimentoOrdineContainer.add(testoArticoli);

        // Campo inserimento articoli.
        final JTextField articoli = new JTextField( 10 ); // Necessario usare getText per recuperare quello che é scritto dentro.
        c.gridx = 1;
        c.gridy = 0;
        gridbag.setConstraints( articoli, c );
        inserimentoOrdineContainer.add(articoli);



        // Testo per inserimento numero pezzi.
        JLabel testoPezzi = new JLabel("Inserisci la quantitá di ogni articolo: ");
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        gridbag.setConstraints( testoPezzi, c );
        inserimentoOrdineContainer.add(testoPezzi);

        // Campo inserimento pezzi.
        JTextField pezzi = new JTextField( 10 ); // Necessario usare getText per recuperare quello che é scritto dentro.
        c.gridx = 1;
        c.gridy = 1;
        gridbag.setConstraints( pezzi, c );
        inserimentoOrdineContainer.add(pezzi);


        // Tasto per confermare l'inserimento.
        c.gridx = 0;
        c.gridy = 5;
        c.anchor = GridBagConstraints.LINE_START;
        gridbag.setConstraints(conferma, c);
        inserimentoOrdineContainer.add(conferma);
        conferma.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                ContaVuoti( new String(pezzi.getText()) );
                ContaVuoti( new String(articoli.getText()) );

                if( contaCampiVuoti == 0 )
                {
                    String articoliO =  articoli.getText();
                    String pezzoO = pezzi.getText();
                    if ((checkslash(articoliO)==1) && checkslash(pezzoO)==1){
                    String stringa = "5/02 Lug 2018/N-01/"+articoliO+"/"+pezzoO+"/50/0";

                    String daStampa = stringa+"\n";
                    try {
                        writeFile(daStampa);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    new PopUpWindow( 7 );
                    }
                    else {
                        new PopUpWindow(6);
                        inserimentoOrdine.dispose();
                        inserimentoOrdine.setVisible(false);
                    }

                }
                else {

                    new PopUpWindow(6);
                    inserimentoOrdine.dispose();
                    inserimentoOrdine.setVisible(false);
                }

                inserimentoOrdine.dispose();
                inserimentoOrdine.setVisible(false);

            }
        });



        // Tasto home che ritorna alla home della Segreteria.
        c.gridx = 1;
        c.gridy = 5;
        c.anchor = GridBagConstraints.LINE_START;
        gridbag.setConstraints(home, c);
        inserimentoOrdineContainer.add(home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new NegozioWindow();
                inserimentoOrdine.dispose();
                inserimentoOrdine.setVisible(false);
            }
        });

        inserimentoOrdine.setVisible(true);

    }
}

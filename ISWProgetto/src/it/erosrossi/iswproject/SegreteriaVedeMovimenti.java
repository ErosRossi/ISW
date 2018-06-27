package it.erosrossi.iswproject;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class SegreteriaVedeMovimenti {

    private static final JButton home = new JButton("Home Segreteria"); // Bottone per la home
    public Vector<String> bollaEseguiti = new Vector<String>();
    public Vector<String> bolladaEseguire = new Vector<String>();
    public Vector<String> dataEseguiti = new Vector<String>();
    public Vector<String> dataDaEseguire = new Vector<String>();
    public Vector<String> negozioEsegiuti = new Vector<String>();
    public Vector<String> negozioDaEseguire = new Vector<String>();
    // public Vector<String> checkOrdini = new Vector<String>();



    public void getMovEseguitiString() throws IOException {
        String daRitornare = new String();
        String s = new String();
        int contatore = 0;

        FileReader fr = new FileReader("MagazzinoOUT.txt");
        BufferedReader br = new BufferedReader(fr);


        while ( ( s = br.readLine() ) != null )
        {
            String[] strArray = s.split("/");
            bollaEseguiti.add(strArray[0]);
            dataEseguiti.add(strArray[1]);
            negozioEsegiuti.add(strArray[2]);
        }

        br.close();

        //return daRitornare;
    }

    public SegreteriaVedeMovimenti(){

        Object[] titoloEseguiti = {"Numero Bolla", "Data Uscita", "Negozio"};

        JFrame movMagazzino = new JFrame("Movimenti Magazzino"); // Creo la finestra.
        movMagazzino.setSize(600, 500);
        movMagazzino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container movMagazzinoContainer = movMagazzino.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        movMagazzinoContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();

        try {
            getMovEseguitiString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[][] datiEseguiti = new Object[bollaEseguiti.size()][3];
        //Object[0][0]
        for(int i = 0; i < bollaEseguiti.size(); i++ )
        {
            datiEseguiti[i][0] = bollaEseguiti.get(i);
            datiEseguiti[i][1] = dataEseguiti.get(i);
            datiEseguiti[i][2] = negozioEsegiuti.get(i);
            
        }

        JTable tabellaEseguiti;
        tabellaEseguiti = new JTable( datiEseguiti, titoloEseguiti );
        c.gridx = 0;
        c.gridy = 0;
        JScrollPane scroll = new JScrollPane(tabellaEseguiti);
        scroll.setBounds(12,12,1,1);
        gridbag.setConstraints( scroll, c );
        movMagazzinoContainer.add( scroll );

        // Da cambiare la posizione nel layout.
        c.gridx = 0;
        c.gridy = 2;
        gridbag.setConstraints(home, c);
        movMagazzinoContainer.add(home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SegreteriaWindow();
                movMagazzino.dispose();
                movMagazzino.setVisible(false);
            }
        });

        movMagazzino.setVisible(true);

    }

}

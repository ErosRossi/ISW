package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class OrdiniPassatiNegozio {

    private static final JButton home = new JButton("Home Negozio"); // Bottone per la home
    public Vector<String> bollaOrdini = new Vector<String>();
    public Vector<String> dataOrdini = new Vector<String>();
    public Vector<String> pezziOrdini = new Vector<String>();
    public Vector<String> numeroPezziOrdini = new Vector<String>();
    public Vector<String> prezziOrdini = new Vector<String>();
    public Vector<String> esecuzionOrdini = new Vector<String>();


    public void getOrdiniNegozio() throws IOException {

        String daRitornare = new String();
        String s = new String();
        int contatore = 0;

        FileReader fr = new FileReader("Ordini.txt");
        BufferedReader br = new BufferedReader(fr);


        while ( ( s = br.readLine() ) != null )
        {
            String[] strArray = s.split("/");

            if(strArray[2].equals("N-01") )
            {
                bollaOrdini.add(strArray[0]);
                dataOrdini.add(strArray[1]);
                pezziOrdini.add(strArray[3]);
                numeroPezziOrdini.add(strArray[4]);
                prezziOrdini.add(strArray[5]);
                if( strArray[6].equals("0") ){
                    esecuzionOrdini.add("No");
                }
                else
                {
                    esecuzionOrdini.add("Si");
                }
            }
        }

        br.close();

        //return daRitornare;
    }


    public OrdiniPassatiNegozio(){


        Object[] titoloOrdiniNegozio = { "Numero Bolla", "Data Ordine", "Pezzi", "Numero Pezzi", "Prezzo Totale", "Arrivato" };

        JFrame ordiniNegozio = new JFrame("Storico Ordini"); // Creo la finestra.
        ordiniNegozio.setSize(600, 500);
        ordiniNegozio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container ordiniNegozioContainer = ordiniNegozio.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        ordiniNegozioContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();

        try {
            getOrdiniNegozio();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[][] datiOrdiniNegozio = new Object[bollaOrdini.size()][6];
        //Object[0][0]
        for(int i = 0; i < bollaOrdini.size(); i++ )
        {
            datiOrdiniNegozio[i][0] = bollaOrdini.get(i);
            datiOrdiniNegozio[i][1] = dataOrdini.get(i);
            datiOrdiniNegozio[i][2] = pezziOrdini.get(i);
            datiOrdiniNegozio[i][3] = numeroPezziOrdini.get(i);
            datiOrdiniNegozio[i][4] = prezziOrdini.get(i);
            datiOrdiniNegozio[i][5] = esecuzionOrdini.get(i);

        }

        JTable tabellaOrdiniNegozio;
        tabellaOrdiniNegozio = new JTable( datiOrdiniNegozio, titoloOrdiniNegozio );
        c.gridx = 0;
        c.gridy = 0;
        JScrollPane scroll = new JScrollPane(tabellaOrdiniNegozio);
        scroll.setBounds(12,12,1,1);
        gridbag.setConstraints( scroll, c );
        ordiniNegozioContainer.add( scroll );

        // Da cambiare la posizione nel layout.
        c.gridx = 0;
        c.gridy = 2;
        gridbag.setConstraints(home, c);
        ordiniNegozioContainer.add(home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new NegozioWindow();
                ordiniNegozio.dispose();
                ordiniNegozio.setVisible(false);
            }
        });

        ordiniNegozio.setVisible(true);
    }
}

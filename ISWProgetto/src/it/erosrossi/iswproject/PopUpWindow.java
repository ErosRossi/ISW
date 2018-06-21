package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PopUpWindow extends JFrame {
    private static final JButton home = new JButton("Home"); // Bottone per la home
    private static final JButton inserimentoArticolo = new JButton("Inserimento Articolo"); // Bottone per il ritorno all'inserimento dell'articolo


    public PopUpWindow(  int x ) {

        JFrame popup = new JFrame("Attenzione!"); // Creo la finestra.
        popup.setSize(300, 150);
        popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container popupContainer = popup.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        popupContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();

        switch ( x ) // Switch case per decidere cosa stampare in caso di errore; ricordarsi ogni volta di nominare in modo diverso la variabile del testo.
        {
            case 0: // Caso di credenziali di accesso di LoginWindow errrate; ritorno alla LoginWindow.
                JLabel testoErCredenziali = new JLabel( "Credenziali di accesso non valide!");
                c.gridx = 0;
                c.gridy = 0;
                gridbag.setConstraints( testoErCredenziali , c );
                popupContainer.add( testoErCredenziali );

                c.gridx = 0;
                c.gridy = 1;
                gridbag.setConstraints(home, c);
                popupContainer.add(home);
                home.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new LoginWindow();
                        popup.setVisible(false);
                    }
                });

                break;



            case 1: // Caso di campi non tutti completati quando si inserisce un articolo.
                JLabel testoErCampiInserimento = new JLabel( "Non hai compilato tutti i campi!");
                c.gridx = 0;
                c.gridy = 0;
                gridbag.setConstraints( testoErCampiInserimento , c );
                popupContainer.add( testoErCampiInserimento );

                c.gridx = 0;
                c.gridy = 1;
                gridbag.setConstraints(inserimentoArticolo, c);
                popupContainer.add(inserimentoArticolo);
                inserimentoArticolo.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new InserimentoArticoliSegreteria();
                        popup.setVisible(false);
                    }
                });

                break;

        }

        popup.setVisible(true);
    }
}

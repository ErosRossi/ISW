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
    private static final JButton modificaPos = new JButton("Modifica Posizione");
    private static final JButton inserisciOrdine = new JButton("Inserisci Ordine");
    private static final JButton inserisciOrdineN = new JButton("Inserisci Ordine");

    public PopUpWindow(  int x ) {

        JFrame popup = new JFrame("Attenzione!"); // Creo la finestra.
        popup.setSize(550, 150);
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
                        popup.dispose();
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
                        popup.dispose();
                        popup.setVisible(false);
                    }
                });

                break;



            case 2: // Caso di articolo giá inserito nel catalogo.
                JLabel testoArticoloGiaInserito = new JLabel( "L' articolo é giá presente nel nostro catalogo oppure uno dei campi non è valido!");
                c.gridx = 0;
                c.gridy = 0;
                gridbag.setConstraints( testoArticoloGiaInserito , c );
                popupContainer.add( testoArticoloGiaInserito );

                c.gridx = 0;
                c.gridy = 1;
                gridbag.setConstraints(inserimentoArticolo, c);
                popupContainer.add(inserimentoArticolo);
                inserimentoArticolo.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new InserimentoArticoliSegreteria();
                        popup.dispose();
                        popup.setVisible(false);
                    }
                });

                break;

            case 3: // Impossibile cambiare posizione
                JLabel testoImpossibileModifica = new JLabel( "Non é possibile modificare eseguire l'operazione ");
                c.gridx = 0;
                c.gridy = 0;
                gridbag.setConstraints( testoImpossibileModifica , c );
                popupContainer.add( testoImpossibileModifica );

                c.gridx = 0;
                c.gridy = 1;
                gridbag.setConstraints(modificaPos, c);
                popupContainer.add(modificaPos);
                modificaPos.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new MagazzinoModificaPosizione();
                        popup.dispose();
                        popup.setVisible(false);
                    }
                });

                break;


            case 4: // Operazione corretta di MagazzinoModificaPosizione
                JLabel testoOperazioneCorrettaMMP = new JLabel( "Operazione avvenuta con successo!");
                c.gridx = 0;
                c.gridy = 0;
                gridbag.setConstraints( testoOperazioneCorrettaMMP , c );
                popupContainer.add( testoOperazioneCorrettaMMP );

                c.gridx = 0;
                c.gridy = 1;
                gridbag.setConstraints(modificaPos, c);
                popupContainer.add(modificaPos);
                modificaPos.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new MagazzinoModificaPosizione();
                        popup.dispose();
                        popup.setVisible(false);
                    }
                });

                break;


            case 5: // Operazione corretta di MagazzinoAggiungeOrdine
                JLabel testoOperazioneCorrettaMAO = new JLabel( "Operazione avvenuta con successo!");
                c.gridx = 0;
                c.gridy = 0;
                gridbag.setConstraints( testoOperazioneCorrettaMAO , c );
                popupContainer.add( testoOperazioneCorrettaMAO );

                c.gridx = 0;
                c.gridy = 1;
                gridbag.setConstraints(inserisciOrdine, c);
                popupContainer.add(inserisciOrdine);
                inserisciOrdine.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new MagazzinoAggiungeOrdine();
                        popup.dispose();
                        popup.setVisible(false);
                    }
                });

                break;


            case 6: // Operazione errata inserimento
                JLabel testoCampiInvalidi = new JLabel( "Inserimento campi invalido");
                c.gridx = 0;
                c.gridy = 0;
                gridbag.setConstraints( testoCampiInvalidi , c );
                popupContainer.add( testoCampiInvalidi );

                c.gridx = 0;
                c.gridy = 1;
                gridbag.setConstraints(inserisciOrdineN, c);
                popupContainer.add(inserisciOrdineN);
                inserisciOrdineN.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new NegozioInserisceOrdine();
                        popup.dispose();
                        popup.setVisible(false);
                    }
                });

                break;


            case 7: // Operazione corretta NegozioInserisceOrdini
                JLabel testoOperazioneCorrettaN = new JLabel( "Operazione avvenuta con successo!");
                c.gridx = 0;
                c.gridy = 0;
                gridbag.setConstraints( testoOperazioneCorrettaN , c );
                popupContainer.add( testoOperazioneCorrettaN );

                c.gridx = 0;
                c.gridy = 1;
                gridbag.setConstraints(inserisciOrdineN, c);
                popupContainer.add(inserisciOrdineN);
                inserisciOrdineN.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new NegozioInserisceOrdine();
                        popup.dispose();
                        popup.setVisible(false);
                    }
                });

                break;

            case 8: // Operazione corretta di MagazzinoAggiungeOrdine
                JLabel testoOperazioneErrataMAO = new JLabel( "Inserimento corriere non valido!");
                c.gridx = 0;
                c.gridy = 0;
                gridbag.setConstraints( testoOperazioneErrataMAO , c );
                popupContainer.add( testoOperazioneErrataMAO );

                c.gridx = 0;
                c.gridy = 1;
                gridbag.setConstraints(inserisciOrdine, c);
                popupContainer.add(inserisciOrdine);
                inserisciOrdine.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new MagazzinoAggiungeOrdine();
                        popup.dispose();
                        popup.setVisible(false);
                    }
                });

                break;
        }

        popup.setVisible(true);
    }
}

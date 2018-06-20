package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MagazzinoModificaPosizione extends JFrame {
    

    public MagazzinoModificaPosizione(  )
    {

        final JFrame modificaPosizione = new JFrame("Modifica Posizione"); // Inizializzo la finestra con un titolo.
        modificaPosizione.setSize(600, 500);
        modificaPosizione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container magazzinoModPosizioneContainer = modificaPosizione.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        magazzinoModPosizioneContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();

    }
}

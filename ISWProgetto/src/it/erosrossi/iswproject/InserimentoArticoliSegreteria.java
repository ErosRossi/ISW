package it.erosrossi.iswproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class InserimentoArticoliSegreteria extends JFrame {
    private static final JButton home = new JButton("Home");


    public InserimentoArticoliSegreteria(  )
    {

        JFrame inserimentoArticoli = new JFrame("Inserimento Articoli"); // Creo la finestra.
        inserimentoArticoli.setSize(600, 500);
        inserimentoArticoli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container inserimentoArticoliContainer = inserimentoArticoli.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        inserimentoArticoliContainer.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();



        inserimentoArticoli.setVisible(true);
    }
}

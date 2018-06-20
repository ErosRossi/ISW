package it.erosrossi.iswproject;

import javax.swing.*;
import java.io.*;

/**
 * Classe main dell'applicazione
 *
 * @author Eros Rossi
 */
public class Main {

    /**
     * Entry point del programma
     *
     * @param args argomenti del programma
     */
    public static void main(String[] args) throws IOException {

        int controllo = 2;
        // imposto menù globale macOS
        System.setProperty("apple.awt.application.name", "Applicazione Astolfi-Rossi");
        System.setProperty("apple.laf.useScreenMenuBar", "true");

        // imposto stile nativo UI di sistema
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        // creo la finestra principale
        new LoginWindow();



    }
}

package it.erosrossi.iswproject;

import javax.swing.*;

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
    public static void main(String[] args) {

        int controllo = 2;
        // imposto menù globale macOS
        System.setProperty("apple.awt.application.name", "prova");
        System.setProperty("apple.laf.useScreenMenuBar", "true");

        // imposto stile nativo UI di sistema
  try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
      e.printStackTrace();
      }

        // creo la finestra principale
        new LoginWindow();
    }
}

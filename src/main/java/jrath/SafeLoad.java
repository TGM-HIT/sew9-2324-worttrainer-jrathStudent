package jrath;

import java.io.*;
import java.util.Scanner;

/**
 * Speichert und lädt WortTrainer (inkl. allen WortEinträgen und Statistiken). Zusätzlich speichert und lädt
 * es eine Default-Datei, welche keine Parameter besitzt.
 * @author Rath Jasmin
 * @version 18.11.2023
 */
public class SafeLoad implements SLInterface{
    private WortTrainer trainer;
    private String filename = "Worttrainer.txt";

    //Konstruktor
    public SafeLoad(WortTrainer t){
        this.trainer = t;
    }

    /**
     * Hier werden die Versuche zurückgegeben.
     * @return Versuche werden zurückgegeben
     */
    public int getVersuche() {
        return trainer.getVersuche();
    }
    /**
     * Hier wird die Anzahl der richtigen Antworten zurückgegeben.
     * @return Anzahl der richtigen Antworten zurückgegeben
     */
    public int getRichtig() {
        return trainer.getRichtig();
    }

    /**
     * Hier wird das Programm in einem Textdokument gespeichert, in einem speziell gewählten Ordner.
     * @param filename Der speicherort
     * @throws IOException Excpetion
     */
    public void speichern(String filename) throws IOException {
        File f = new File(filename);
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(f));
        writer.write(trainer.getVersuche() + System.lineSeparator() + trainer.getRichtig() + System.lineSeparator() + trainer.getWrong() + System.lineSeparator());
        writer.close();
    }

    /**
     * Hier wird das Programm in einer Textdatei abgespeichert. Der Speicherort ist fix.
     * @throws IOException Edxception
     */
    public void speichern() throws IOException{
        speichern(this.filename);
    }

    /**
     * Hier wird die datei geladen. Der Speicherort ist fix.
     * @throws IOException
     */
    public void laden(String filename) throws IOException {
        Scanner reader = new Scanner(new BufferedReader(new FileReader(filename)));
        try {
            int fragen = Integer.parseInt(reader.nextLine());
            int richtige = Integer.parseInt(reader.nextLine());
            int falsche = Integer.parseInt(reader.nextLine());
            trainer.addVersuche(fragen);
            trainer.addRichtig(richtige);
            trainer.addWrong(falsche);
        } finally {
            reader.close();
        }
    }

    /**
     * Lädt die datei mit einem angegebenen speicherort
     * @throws IOException
     */
    public void laden() throws IOException {
        laden(this.filename);
    }
}
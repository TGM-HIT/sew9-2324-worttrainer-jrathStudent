package jrath;

import java.util.Random;

/**
 * Übernimmt Einträge überprüft diese (auch unabhängig von Groß-Kleinschreibung).
 * @author Rath Jasmin
 * @version 18.11.2023
 */
public class WortTrainer {
    private WortListe wordList;
    private int anzahlFragen;
    private int wrong;
    private int right;

    public WortTrainer(WortListe wl){
        wordList = wl;
        anzahlFragen = 0;
        wrong = 0;
        right = 0;
    }

    public int getVersuche() {
        return anzahlFragen;
    }

    public int getRichtig() {
        return right;
    }

    public int getWrong() {
        return wrong;
    }

    public void setVersuche(int versuche) {
        this.anzahlFragen = versuche;
    }

    public void setRichtig(int richtig) {
        this.right = richtig;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public void addVersuche(int zahl){anzahlFragen += zahl;}

    public void addRichtig(int zahl){right += zahl;}

    public void addWrong(int zahl){wrong += zahl;}

    //Wortliste
    public WortListe getWordList(){return this.wordList;}

    /**
     * Wählt einen zufälligen WortEintrag aus der Liste aus und gibt ihn zurück.
     * @return
     */
    public WortEintrag randomWord() {
        Random random = new Random(this.wordList.getLength());
        int r = random.nextInt(this.wordList.getLength());
        for (int i = 0; i < this.wordList.getLength(); i++) {
            if(this.wordList.getEnrty(r)!=null){
                return wordList.getEnrty(r);
            }
        }
        return null;
    }

    /**
     * Gibt zurück, ob das Wort im Parameter mit dem aktuellen WortEintrag übereinstimmt.
     * @param word
     * @return
     */
    public boolean check(String word, int index) {
        anzahlFragen++;
        if(wordList.getEntry(index).getWord().equals(word)) {
            right++;
            return true;
        }
        wrong++;
        return false;
    }

    /**
     * Arbeitet ähnlich zu Methode check aber ignoriert Groß-Kleinschreibung.
     * @return
     */
    public boolean checkIgnoreCase(String wort, int index) {
        anzahlFragen++;
        if(this.wordList.getEntry(index).getWord().toLowerCase().equals(wort.toLowerCase())) {
            right++;
            return true;
        }
        wrong++;
        return false;
    }

    /**
     * Gibt die Statistic zurück.
     * @return
     */
    public String statistic() {
        return "Es sind " +right+ "/" +anzahlFragen+ " richtig und " +wrong+ "/" +anzahlFragen+ " der Fragen sind falsch.";
    }

}

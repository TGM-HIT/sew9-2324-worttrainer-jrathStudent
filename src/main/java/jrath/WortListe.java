package jrath;

import javax.swing.*;
/**
 * Methoden zur Festlegung und Überprüfung von Arrays, Gültigkeit durch Exceptions.
 * @author Rath Jasmin
 * @version 18.11.2023
 */
public class WortListe {
    private WortEintrag[] wordEntry = new WortEintrag[0];

    public WortEintrag getEnrty(int index) {
        for(int i=0; i<wordEntry.length ; i++) {
            if(wordEntry[i]!=null) {
                if(i == index) {
                    return this.wordEntry[i];
                }
            }
        }
        return this.wordEntry[0];
    }

    public WortEintrag[] getWordEntry() {
        return wordEntry;
    }

    public WortEintrag[] getArray(){
        return wordEntry;
    }

    public int getLength(){return wordEntry.length;}

    /**
     * Fügt ein neues Wort hinzu.
     * @param wordE
     * @param url
     */
    public void addArray(String wordE, String url){
        WortEintrag[] array2 = new WortEintrag[wordEntry.length + 1];
        for(int i = 0; i < wordEntry.length; i++) {
            array2[i] = wordEntry[i];
        }
        array2[array2.length - 1] = new WortEintrag(wordE, url);
        wordEntry = array2;
    }

    /**
     * Gibt den WortEintrag zu einem übergebenen Index zurück.
     * @param index
     * @return
     */
    public WortEintrag getEntry(int index){
        if (index >= 0 && index <= wordEntry.length) {
            return wordEntry[index];
        }
        else {
            throw new IllegalArgumentException("Invalid!");
        }
    }

    /**
     * Das übergebene Wort wird gelöscht.
     * @param word
     * @return
     */
    public boolean deleteArray(String word){
        if(word != null) {
            for (int i = 0; i < wordEntry.length; i++) {
                if (wordEntry[i].getWord().equals(word)) {
                    WortEintrag[] temp = new WortEintrag[wordEntry.length - 1];
                    for (int x = 0; x < wordEntry.length - 1; x++) {
                        if(x != 1) {
                            temp[x] = wordEntry[x];
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Überschreibt toString so, dass jeder WortEintrag in einer eigenen Zeile zurückgegeben wird.
     * @return
     */
    @Override
    public String toString(){
        String output = "";
        for(int i = 0; i < wordEntry.length; i++){
            output += (wordEntry[i].toString() +"\n");
        }
        return output;
    }
}

package jrath;

import javax.swing.*;
import java.util.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * Methode zur Überprüfung der URL (Sinnhaftigkeit) und Gültigkeit durch Exceptions.
 * @author Rath Jasmin
 * @version 18.11.2023
 */

public class WortEintrag {
    private String word;
    private String url;

    public WortEintrag(String word, String url){
        if(checkURL(url)==true){
            this.url = url;
        }
        this.word = word;
    }

    //Setter-/Getter-Methoden
    public String getWord(){
        return word;
    }

    public void setWord(String word){
        try {
            if(word.length() >= 2) {
                this.word = word;
            }
            else {
                throw new IllegalArgumentException("Wort ist zu kurz");
            }
        }
        catch(IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        if(checkURL(url) == true) {
            this.url = url;
        }
        else {
            JOptionPane.showMessageDialog(null, "URL ungültig", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Prüft url auf Sinnhaftigkeit.
     * @return true, wenn gültig
     */
    public static boolean checkURL(String urlE){
        if(urlE==null) {
            throw new NullPointerException("URL ist leer");
        }
        else {
            try {
                URL web = new URL(urlE);
                web.toURI();
                return true;
            } catch(MalformedURLException e) {
                return false;
            } catch(URISyntaxException e) {
                return false;
            }
        }
    }

    /**
     * Das Wort wird gefolt von einem Semikolon und der URL zurückgegeben.
     * @return
     */
    @Override
    public String toString(){
        return this.word +"; "+ this.url;
    }
}

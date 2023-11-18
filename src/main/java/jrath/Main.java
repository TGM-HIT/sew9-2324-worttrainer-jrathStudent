package jrath;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

/**
 * Main-Methode
 * @author Rath Jasmin
 * @version 18.11.2023
 */
public class Main {
    public static void main(String[] args) {

        //initialise words and add to list
        WortListe wortliste = new WortListe();
        wortliste.addArray("Hund", "https://cdn.unitycms.io/images/0jQ0i9fPqINBr3lL3NuRt6.jpg?op=ocroped&val=1200,1200,1000,1000,0,0&sum=hnl43A3hcb4");
        wortliste.addArray("Katze", "https://static.displate.com/857x1200/displate/2022-07-07/fb201c5aef2a8558a1eec3a095be6d49_1c1023275f02c2ee7bc146309a812775.jpg");
        wortliste.addArray("Pinguin", "https://static.printler.com/cache/e/6/9/9/3/1/e69931c88a008d5002cb30c1e9271e36b39522d4.jpg");
        wortliste.addArray("Delphin", "https://i.kym-cdn.com/entries/icons/facebook/000/003/734/dolphin.jpg");
        wortliste.addArray("Baer", "https://img.freepik.com/vektoren-premium/netter-baer-mit-bubble-tea-cartoon-vektorillustration_42750-816.jpg");

        WortTrainer worttrainer = new WortTrainer(wortliste);

        //safe und load Methoden
        SLInterface speichern = new SafeLoad(worttrainer);
        SLInterface laden = new SafeLoad(worttrainer);
        try {
            laden.laden();
        } catch (IOException e) {
            System.out.println("laden fehlgeschlagen");
        }

        Random r = new Random();
        ImageIcon icon;
        boolean right = false, beenden = false;

        //Solange nicht beendet wird
        while(!beenden){

            WortEintrag zufall = worttrainer.getWordList().getArray()[r.nextInt(worttrainer.getWordList().getArray().length)];

            do {
                //Bildausgabe
                try {
                    icon = new ImageIcon(new URL(zufall.getUrl()));
                    JOptionPane.showMessageDialog(null, "Was siehst du auf diesem Bild?", "Image", JOptionPane.INFORMATION_MESSAGE, icon);
                    String antwort = JOptionPane.showInputDialog(null, "Was hast du auf dem Bild vorhin gesehen?", "Frage", JOptionPane.QUESTION_MESSAGE).toString();

                    //Bei einer leeren Ausgabe wird das Programm beendet
                    if(antwort.equals("")){
                        try {
                            speichern.speichern();
                        } catch (IOException e) {
                            System.out.println("speichern fehlgeschlagen");
                        }

                        beenden = true;
                        break;
                    }

                    if(antwort.equals(zufall.getWord())){
                        JOptionPane.showMessageDialog(null, "Das ist korrekt!");
                        worttrainer.addRichtig(1);
                        worttrainer.addVersuche(1);
                        right = true;

                    }else{
                        JOptionPane.showMessageDialog(null, "Leider nicht korrekt!");
                        worttrainer.addWrong(1);
                        worttrainer.addVersuche(1);
                        right = false;

                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } while (!right);

        }

        //Statistiken werden ausgegeben
        JOptionPane.showMessageDialog(null, worttrainer.statistic(), "Statistik",JOptionPane.INFORMATION_MESSAGE);
    }
}

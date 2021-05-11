package calculator.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Laskimen muistista vastaava luokka
 */
public class History {
    private String filename;

    public History() {
        filename = "history.txt";
    }
    
    /**
     * Metodi lukee tekstitiedoston history.txt ja tulostaa sen
     */
    public void readHistory() {
        try (Scanner tiedostonLukija = new Scanner(new File(filename))) {
            while (tiedostonLukija.hasNextLine()) {
                System.out.println(tiedostonLukija.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui.");
        }
    }
    
    /**
     * Metodi tallentaa tekstiä jo olemassa olevaan tekstitiedostoon
     * @param txt teksti, joka halutaan tallentaa
     */
    public void writeHistory(String txt) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.append(txt);
            writer.close();
        } catch (Exception e) {
            System.out.println("Tiedostoon kirjoittaminen epäonnistui.");
        }              
    }
    
    /**
     * Metodi tekee tekstitiedostosta tyhjän
     */
    public void clearHistory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.append("");
            writer.close();
        } catch (Exception e) {
            System.out.println("Tiedoston tyhjentäminen epäonnistui.");
        }
    }
    
    public void setFile(String name) {
        filename = name;
    }
    
    
    
}

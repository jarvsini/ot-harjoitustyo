/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author jarvsini
 */
public class History {
    private String filename;

    public History() {
        filename = "history.txt";
    }
    
    public void readHistory() {
        try (Scanner tiedostonLukija = new Scanner(new File(filename))) {
            while (tiedostonLukija.hasNextLine()) {
                System.out.println(tiedostonLukija.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnstui.");
        }
    }
    
    public void writeHistory(String txt) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.append(txt);
            writer.close();
        } catch (Exception e) {
            System.out.println("Tiedostoon kirjoittaminen epäonnistui.");
        }      
        
    }
    
    public void clearHistory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.append("");
            writer.close();
        } catch (Exception e) {
            System.out.println("Tiedoston tyhjentäminen epäonnistui.");
        }
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaus;

import domain.Translator;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Luokka jätetty kommentoinnin ulkopuolelle, sillä se ei ole osa varsinaista ohjelmaa. Käyttää valmiita tietorakenteita samasta syystä.
 * @author tuomoart
 */
public class Testaaja {
    private ArrayList<String> testit;
    private Translator tulkki;
    
    public Testaaja(Translator t) {
        tulkki = t;
        testit = new ArrayList();
        testit.add("(a|b|c)*");
        testit.add("(a|b|c|d|e|f|g|h|i|j|k|l|m|n)*");
    }
    
    public void testaa() {
        long aikaOmaYht = 0;
        long aikaJavaYht = 0;
        System.out.println("\n");
        
        for (int i = 1; i <= testit.size(); i++) {
            long aika1 = System.nanoTime();
            String rgx = testit.get(i - 1);
            
            try (Scanner tiedostonLukija = new Scanner(Paths.get(i + ".txt"))) {
                
                while (tiedostonLukija.hasNextLine()) {
                    String rivi = tiedostonLukija.nextLine();
                    
                    if (rivi.isEmpty()) {
                        continue;
                    }
                    
                    if (!tulkki.matches(rivi, rgx)) {
                        System.out.println("Virhe!");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
            
            aika1 = System.nanoTime() - aika1;
            aikaOmaYht += aika1;
            System.out.println("Omalla toteutuksella kesti " + aika1 / 10e9 + " sekuntia testissä " + i);
        }
        
        System.out.println("");
        
        for (int i = 1; i <= testit.size(); i++) {
            long aika2 = System.nanoTime();
            Pattern pattern = Pattern.compile(testit.get(i - 1));
            
            try (Scanner tiedostonLukija = new Scanner(Paths.get(i + ".txt"))) {
                
                while (tiedostonLukija.hasNextLine()) {
                    String rivi = tiedostonLukija.nextLine();
                    
                    if (rivi.isEmpty()) {
                        continue;
                    }
                    
                    Matcher matcher = pattern.matcher(rivi);
                    if (!matcher.matches()) {
                        System.out.println("Virhe!");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Virhe: " + e.getMessage());
            }
            
            aika2 = System.nanoTime() - aika2;
            aikaJavaYht += aika2;
            System.out.println("Javan toteutuksella kesti  " + aika2 / 10e9 + " sekuntia testissä " + i);
        }
        
        System.out.println("");
        System.out.println("Omalla toteutuksella kesti yhteensä " + aikaOmaYht / 10e9 + " sekuntia");
        System.out.println("Javan toteutuksella kesti yhteensä  " + aikaJavaYht / 10e9 + " sekuntia");
        System.out.println("\n");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Translator;
import java.util.Scanner;
import testaus.Testaaja;

/**
 *
 * @author tuomoart
 */
public class Cli {
    private Scanner lukija;
    private Translator t;
    
    public Cli(Scanner lukija, Translator t) {
        this.lukija = lukija;
        this.t = t;
    }
    
    public void kaynnista() {
        while (true) {
            System.out.print("Syöte (. lopettaa): ");
            String syote = lukija.nextLine();
            
            if (syote.equals(".")) {
                break;
            } else if (syote.equals("testaa")) {
                Testaaja testaaja = new Testaaja(t);
                testaaja.testaa();
                continue;
            }
            
            System.out.print("lauseke: ");
            String lauseke = lukija.nextLine();
            
            if (t.matches(syote, lauseke)) {
                System.out.println("Kuuluu");
            } else {
                System.out.println("Ei kuulu");
            }
        }
    }
}

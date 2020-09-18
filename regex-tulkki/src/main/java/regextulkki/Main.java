/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regextulkki;

import domain.Translator;
/**
 *
 * @author tuomoart
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String syote = "b";
        String lauseke = "a";
        
        Translator tulkki = new Translator();
        
        if (tulkki.matches(syote, lauseke)) {
            System.out.println("Kuuluu");
        } else {
            System.out.println("Ei kuulu");
        }
    }
}

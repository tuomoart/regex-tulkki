/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regextulkki;

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
        String syote = "aaabbbbcccc";
        String lauseke = "a*b*c*";
        
        char[] syoteChars = syote.toCharArray();
        char[] lausekeChars = lauseke.toCharArray();
        
        boolean kuuluu = true;
        
        int lausekeI = 0;
        int syoteI = 0;
        
        while (lausekeI<lausekeChars.length && syoteI<syoteChars.length) {
            if (lausekeChars[lausekeI]=='*') {
                while (syoteI<syoteChars.length && syoteChars[syoteI]==lausekeChars[lausekeI-1]) {
                    syoteI++;
                }
                lausekeI++;
                continue;
            }
            
            if (syoteChars[syoteI]!=lausekeChars[lausekeI]) {
                kuuluu = false;
                break;
            }
            
            lausekeI++;
            syoteI++;
        }
        
        //Jos jompaa kumpaa ei käyty loppuun, erityisesti syötettä niin ei täsmännyt, paitsi jos lauseke loppui kesken mutta viimeinen merkki oli operaattori
        if (syoteI<syoteChars.length || (lausekeI<lausekeChars.length && lausekeChars[lausekeChars.length-1]!='*')) {
            kuuluu = false;
        }

        System.out.println(kuuluu);
    }
}

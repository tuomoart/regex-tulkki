/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Arrays;

/**
 *
 * @author tuomoart
 */
public class Translator {
    public boolean matches(String s, String l) {
        char[] syoteChars = s.toCharArray();
        char[] lausekeChars = l.toCharArray();
        
        boolean kuuluu = tarkasta(syoteChars, lausekeChars, (char) 127);
        
//        int lausekeI = 0;
//        int syoteI = 0;
//        
//        while (lausekeI<lausekeChars.length && syoteI<syoteChars.length) {
//            if (lausekeChars[lausekeI]=='*') {
//                while (syoteI<syoteChars.length && syoteChars[syoteI]==lausekeChars[lausekeI-1]) {
//                    syoteI++;
//                }
//                lausekeI++;
//                continue;
//            }
//            
//            if (syoteChars[syoteI]!=lausekeChars[lausekeI]) {
//                if (lausekeChars[lausekeI]!='*') {
//                    lausekeI++;
//                    continue;
//                }
//                kuuluu = false;
//                System.out.println("syoteI: " + syoteI + " lausekeI: " + lausekeI);
//                System.out.println("syote: "+ syoteChars[syoteI] + " lauseke: " + lausekeChars[lausekeI]);
//                break;
//            }
//            
//            lausekeI++;
//            syoteI++;
//        }
//        
//        //Jos jompaa kumpaa ei käyty loppuun, erityisesti syötettä niin ei täsmännyt, paitsi jos lauseke loppui kesken mutta viimeinen merkki oli operaattori
//        if (syoteI<syoteChars.length || (lausekeI<lausekeChars.length && lausekeChars[lausekeChars.length-1]!='*')) {
//            kuuluu = false;
//        }

        return kuuluu;
    }
    
    private boolean tarkasta(char[] syote, char[] lauseke, char viime) {
        
        System.out.println(Arrays.toString(syote));
        System.out.println(Arrays.toString(lauseke));
        System.out.println("viime: " + viime);
        System.out.println("");
        
        if (syote.length == 0) {
            if (lauseke.length == 0) {
                return true;
            } else if (lauseke.length == 2 && lauseke[1]== '*') {
                return true;
            } else if (lauseke.length == 1 && lauseke[0] == '*') {
                return true;
            } else {
                return false;
            }
        } else if (lauseke.length == 0) {
            return false;
        } else if (syote[0] == lauseke[0]) {
            return tarkasta(poista1(syote), poista1(lauseke), lauseke[0]);
        } else if (lauseke[0] == '*') {
            if (syote [0] != viime) {
                return tarkasta(syote, poista1(lauseke), lauseke[0]);
            } else {
                return tarkasta(poista1(syote), lauseke, viime);
            }
        } else if (lauseke.length>1 && lauseke[1] == '*') {
            return tarkasta(syote, poista(lauseke, 2), lauseke[1]);
        }
        
        return false;
    }
    
    private char[] poista1(char[] c) {
        return poista(c, 1);
    }
    
    private char[] poista(char[] c, int m) {
        char[] r = new char[c.length-m];
        
        for (int i = m; i<c.length; i++) {
            r[i-m] = c[i];
        }
        
        return r;
    }
}

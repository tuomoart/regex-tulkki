package domain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author tuomoart
 */
public class Translator {
    /**
     * Tarkasta, täsmääkö syöte annettuun säännölliseen lausekkeeseen
     * @param s Tutkittava syöte
     * @param l Säännöllinen lauseke jota vastaan syötettä tutkitaan
     * @return boolean
     */
    public boolean matches(String s, String l) {
        Merkkijono syoteChars = new Merkkijono(s);
        Merkkijono lausekeChars = new Merkkijono(l);
        
        boolean kuuluu = tarkasta(syoteChars, lausekeChars, new Merkkijono((char) 7), new Merkkijono((char) 127));
        
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
    
    private boolean tarkasta(Merkkijono syote, Merkkijono lauseke, Merkkijono viimeS, Merkkijono viimeL) {
        
        //Diagnostiikkaa varten printtejä
        System.out.println(syote.toString());
        System.out.println(lauseke.toString());
        System.out.println("viimeL: " + viimeL.toString());
        System.out.println("viimeS: " + viimeS.toString());
        System.out.println("");
        
        if (syote.length() == 0) {
            if (lauseke.length() == 0) {
                return true;
            } else if (lauseke.get(0) == '+') {
                return true;
            } else if (lauseke.length() == 2 && lauseke.get(1) == '*') {
                return true;
            } else if (lauseke.length() == 1 && lauseke.get(0) == '*') {
                return true;
            } else {
                return false;
            }
        } else if (lauseke.length() == 0) {
            return false;
        } else if (syote.get(0) == lauseke.get(0)) {
            viimeS = new Merkkijono(syote.get(0));
            viimeL = new Merkkijono(lauseke.get(0));
            syote.poista1();
            lauseke.poista1();
            return tarkasta(syote, lauseke, viimeS, viimeL);
        } else if (lauseke.get(0) == '*') {
            if (syote.get(0) != viimeL.get(0)) {
                viimeS = new Merkkijono(syote.get(0));
                viimeL = new Merkkijono(lauseke.get(0));
                lauseke.poista1();
                return tarkasta(syote, lauseke, viimeS, viimeL);
            } else {
                viimeS = new Merkkijono(syote.get(0));
                syote.poista1();
                return tarkasta(syote, lauseke, viimeS, viimeL);
            }
        } else if (lauseke.get(0) == '+') {
            if (!viimeS.equals(viimeL)) {
                viimeS = new Merkkijono(syote.get(0));
                viimeL = new Merkkijono(lauseke.get(0));
                lauseke.poista1();
                return tarkasta(syote, lauseke, viimeS, viimeL);
            } else {
                viimeS = new Merkkijono(syote.get(0));
                syote.poista1();
                return tarkasta(syote, lauseke, viimeS, viimeL);
            }
        } else if (lauseke.length() > 1 && lauseke.get(1) == '*') {
            viimeS = new Merkkijono(syote.get(0));
            viimeL = new Merkkijono(lauseke.get(1));
            lauseke.poista(2);
            return tarkasta(syote, lauseke, viimeS, viimeL);
        }
        
        return false;
    }
    
    //Metodi jossa myös sulkutoiminnon alku:
    
//    private boolean tarkasta(char[] syote, char[] lauseke, char[] viimeS, char[] viimeL) {
//        
//        //Diagnostiikkaa varten printtejä
//        System.out.println(Arrays.toString(syote));
//        System.out.println(Arrays.toString(lauseke));
//        System.out.println("viimeL: " + Arrays.toString(viimeL));
//        System.out.println("viimeS: " + Arrays.toString(viimeS));
//        System.out.println("");
//        
//        if (syote.length == 0) {
//            if (lauseke.length == 0) {
//                return true;
//            } else if (lauseke[0] == '+') {
//                return true;
//            } else if (lauseke.length == 2 && lauseke[1] == '*') {
//                return true;
//            } else if (lauseke.length == 1 && lauseke[0] == '*') {
//                return true;
//            } else {
//                return false;
//            }
//        } else if (lauseke.length == 0) {
//            return false;
//        } else if (syote[0] == lauseke[0]) {
//            return tarkasta(poista1(syote), poista1(lauseke), new char[] {syote[0]}, new char[] {lauseke[0]});
//        } else if (lauseke[0] == '*') {
//            if (syote [0] != viimeL[0]) {
//                return tarkasta(syote, poista1(lauseke), new char[] {syote[0]}, new char[] {lauseke[0]});
//            } else {
//                return tarkasta(poista1(syote), lauseke, new char[] {syote[0]}, viimeL);
//            }
//        } else if (lauseke[0] == '+') {
//            if (!Arrays.equals(viimeS, viimeL) || syote[0] == viimeL) {
//                return tarkasta(syote, poista1(lauseke), new char[] {syote[0]}, new char[] {lauseke[0]});
//            } else {
//                return tarkasta(poista1(syote), lauseke, new char[] {syote[0]}, viimeL);
//            }
//        } else if (lauseke[0] == '(') {
//            ArrayList<Character> between = new ArrayList();
//            for (int i = 1; lauseke[i] != ')'; i++) {
//                between.add(lauseke[i]);
//            }
//            char[] uusiViimeL = new char[between.size()];
//            for (int i = 0; i<between.size(); i++) {
//                uusiViimeL[i] = between.get(i);
//            }
//            return tarkasta(syote, poista(lauseke, between.size()+2), viimeS, uusiViimeL);
//        } else if (lauseke.length > 1 && lauseke[1] == '*') {
//            return tarkasta(syote, poista(lauseke, 2), new char[] {syote[0]}, new char[] {lauseke[1]});
//        }
//        
//        return false;
//    }
    
//    private char[] poista1(char[] c) {
//        return poista(c, 1);
//    }
//    
//    private char[] poista(char[] c, int m) {
//        char[] r = new char[c.length - m];
//        
//        for (int i = m; i < c.length; i++) {
//            r[i - m] = c[i];
//        }
//        
//        return r;
//    }
}

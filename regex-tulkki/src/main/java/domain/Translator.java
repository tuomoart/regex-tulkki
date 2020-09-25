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
        
        return tarkasta(syoteChars, lausekeChars, new Merkkijono((char) 7), new Merkkijono((char) 127));
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
}

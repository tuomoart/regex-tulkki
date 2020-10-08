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
        lausekeChars = lisaaSulut(lausekeChars);
        
        return tarkasta(syoteChars, lausekeChars);
    }
    
    private boolean tarkasta(Merkkijono syote, Merkkijono lauseke) {
        
        //Diagnostiikkaa varten printtejä
//        System.out.println("syote: " + syote.toString());
//        System.out.println("lauseke: " + lauseke.toString());
//        System.out.println("");
        
        //Jos molemmat ovat loppuneet, syöte täsmää
        if (syote.length() == 0 && lauseke.length() == 0) {
            return true;
        }
        
        //Jos lauseke loppuu mutta syöte ei niin ei täsmää
        if (syote.length() > 0 && lauseke.length() == 0) {
            return false;
        }
        
        //Jos molempien seuraava merkki on sama, niin tämä merkki voidaan hyväksyä ja unohtaa
        if (!onErikoismerkki(lauseke.get(0))) {
            //Jos syöte on loppunut tai sen seuraava merkki on eri kuin lausekkeen, hylkää
            if(syote.length() == 0 || syote.get(0) != lauseke.get(0)) {
                return false;
            }
            
            //Muutoin merkki voidaan hyväksyä, poistaa molemmista ja siirtyä eteenpäin
            syote.poista1();
            lauseke.poista1();
            return tarkasta(syote, lauseke);
        }
        
        //Etsitään lausekkeesta seuraava tarkasteltava osa:
        Merkkijono seuraava = seuraava(lauseke);
        
        //Jos lausekkeen seuraava operaatio on toisto:
        if (lauseke.length()>seuraava.length() && lauseke.get(seuraava.length()) == '*') {
            boolean tasmaa = false;
            
            //Poistetaan lausekkeesta toisto:
            lauseke.poista(seuraava.length() + 1);
            
            //yritetään joka kerta kasvavaa määrää toistettavaa lauseketta
            //kunnes löytyy määrä joka toimii. (Lopetetaan kun toistoja enemmän kuin syötteen pituus.)
            for (int i = 0; !tasmaa && i<syote.length()+1; i++) {
                tasmaa = tarkasta(syote.kloonaa(), lauseke.kloonaa());
                lauseke.lisaaAlkuun(seuraava.kloonaa());
            }
            
            return tasmaa;
        }
        
        //Kun ei ole toistoa, käsitellään seuraavien sulkujen sisältö seuraavana:
        ArrayList<Merkkijono> vaihtoehdot = new ArrayList();
        Merkkijono temp = new Merkkijono();
        
        //Käydään sulkulause läpi ja paloitellaan se erillisiin osiin:
        for (int i = 1; i< seuraava.length()-1; i++) {
            char c = seuraava.get(i);
            
            //Tai-merkin kohdalla aloitetaan uusi osa
            if (c == '|') {
                vaihtoehdot.add(temp);
                temp = new Merkkijono();
                continue;
            }
            
            temp.lisaa(c);
        }
        vaihtoehdot.add(temp);
        
        //Poistetaan sulkulause
        lauseke.poista(seuraava.length());
        
        //Kokeillaan vaihtoehdot vuorotellen
        for (Merkkijono vaihtoehto: vaihtoehdot) {
            lauseke = lauseke.lisaaAlkuun(vaihtoehto);
            
            //Jos jokin vaihtoehto toimii, palauta true
            if (tarkasta(syote.kloonaa(), lauseke.kloonaa())) {
                return true;
            }
            
            //Poista tämä vaihtoehto jos se ei toiminut
            lauseke.poista(vaihtoehto.length());
        }
        
        //Jos yksikään vaihtoehto ei toimintu, hylkää
        return false;
        
    }
    
    public Merkkijono lisaaSulut(Merkkijono m) {
        Merkkijono temp = new Merkkijono();
        
        for (char c: m.getAll()) {
            if (!onErikoismerkki(c)) {
                temp.lisaa('(');
                temp.lisaa(c);
                temp.lisaa(')');
            } else {
                temp.lisaa(c);
            }
        }
        
        return temp;
    }
    
    private Merkkijono seuraava(Merkkijono m) {
        Merkkijono temp = new Merkkijono();
        
        int sulkuja = 0;
        
        for (char c: m.getAll()) {
            if (c == '(') {
                sulkuja++;
            } else if (c == ')') {
                sulkuja--;
            }
            
            temp.lisaa(c);
            
            if (sulkuja == 0) {
                break;
            }
        }
        
        return temp;
    }
    
//    private boolean tarkasta(Merkkijono syote, Merkkijono lauseke, Merkkijono viimeS, Merkkijono viimeL) {
//        
//        //Diagnostiikkaa varten printtejä
//        System.out.println("Syöte: " + syote.toString());
//        System.out.println("Lauseke: " + lauseke.toString());
//        System.out.println("viimeL: " + viimeL.toString());
//        System.out.println("viimeS: " + viimeS.toString());
//        System.out.println("");
//        
//        if (syote.length() == 0) {
//            if (lauseke.length() == 0) {
//                return true;
//            } else if (lauseke.get(0) == '+') {
//                return true;
//            } else if (lauseke.length() == 2 && lauseke.get(1) == '*') {
//                return true;
//            } else if (lauseke.length() == 1 && lauseke.get(0) == '*') {
//                return true;
//            } else if(lauseke.get(lauseke.length()-1)=='*') {
//                return true;
//            } else {
//                return false;
//            }
//        } else if (lauseke.length() == 0) {
//            return false;
//        } else if (syote.get(0) == lauseke.get(0)) {
//            viimeS = new Merkkijono(syote.get(0));
//            viimeL = new Merkkijono(lauseke.get(0));
//            syote.poista1();
//            lauseke.poista1();
//            return tarkasta(syote, lauseke, viimeS, viimeL);
//        } else if (lauseke.get(0) == '*') {
//            if (syote.get(0) != viimeL.get(0)) {
//                viimeS = new Merkkijono(syote.get(0));
//                viimeL = new Merkkijono(lauseke.get(0));
//                lauseke.poista1();
//                return tarkasta(syote, lauseke, viimeS, viimeL);
//            } else {
//                viimeS = new Merkkijono(syote.get(0));
//                syote.poista1();
//                return tarkasta(syote, lauseke, viimeS, viimeL);
//            }
//        //TODO +-operaattorin joutaisi poistaa kun sulut ei tue sitä
//        } else if (lauseke.get(0) == '+') {
//            if (!viimeS.equals(viimeL)) {
//                viimeS = new Merkkijono(syote.get(0));
//                viimeL = new Merkkijono(lauseke.get(0));
//                lauseke.poista1();
//                return tarkasta(syote, lauseke, viimeS, viimeL);
//            } else {
//                viimeS = new Merkkijono(syote.get(0));
//                syote.poista1();
//                return tarkasta(syote, lauseke, viimeS, viimeL);
//            }
//        } else if (lauseke.length() > 1 && lauseke.get(1) == '*') {
//            viimeS = new Merkkijono(syote.get(0));
//            viimeL = new Merkkijono(lauseke.get(1));
//            lauseke.poista(2);
//            return tarkasta(syote, lauseke, viimeS, viimeL);
//        } else if (lauseke.get(0) == '(') {
//            ArrayList<Merkkijono> sisalto = new ArrayList();
//            
//            Merkkijono m = new Merkkijono();
//            Merkkijono mKoko = new Merkkijono('(');
//            
//            int pituus = 0;
//            boolean tai = false;
//            
//            for (int i=1; i<lauseke.length(); i++) {
//                mKoko.lisaa(lauseke.get(i));
//                //TODO sulkujen luku pitäisi muokata sellaiseksi että myös useammat sisäkkäin toimii
//                if (lauseke.get(i)==')') {
//                    sisalto.add(m);
//                    pituus = i+1;
//                    break;
//                } else if (lauseke.get(i) == '|') {
//                    sisalto.add(m);
//                    m = new Merkkijono();
//                    tai = true;
//                    continue;
//                }
//                m.lisaa(lauseke.get(i));
//            }
//            
//            if (lauseke.length() > pituus && lauseke.get(pituus) == '*') {
//                return tarkasta(syote, lauseke.lisaaAlkuun(mKoko), viimeS, viimeL);
//            } else {
//                lauseke.poista(pituus);
//                
//                for (Merkkijono mJono: sisalto) {
//                    if (tarkasta(syote, lauseke.lisaaAlkuun(mJono), viimeS, viimeL)) {
//                        return true;
//                    }
//                }
//                
//            }
//            System.out.println(lauseke);
//            return tarkasta(syote, new Merkkijono(lauseke.poista(pituus)), viimeS, viimeL);
//        }
//        
//        return false;
//    }
    
    private boolean onErikoismerkki(char c) {
        return c == '*' || c == '|' || c == '(' || c == ')';
    }
}

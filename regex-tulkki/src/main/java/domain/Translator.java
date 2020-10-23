package domain;

import java.util.ArrayList;

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
        //Siirrytään omaan tietorakenteeseen
        Merkkijono syoteChars = new Merkkijono(s);
        Merkkijono lausekeChars = new Merkkijono(l);
        
        //Formatoidaan lauseke sopivaksi
        lausekeChars = lisaaSulut(lausekeChars);
        
        return tarkasta(syoteChars, lausekeChars);
    }
    
    /**
     * Tarkasta sulkulause kerrallaan rekursiivisesti, vastaako syöte säännöllistä lauseketta
     * @param syote
     * @param lauseke
     * @return 
     */
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
        int sulkuja = 0;
        
        //Käydään sulkulause läpi ja paloitellaan se erillisiin osiin:
        for (int i = 1; i< seuraava.length()-1; i++) {
            char c = seuraava.get(i);
            
            //Seurataan sulkuja
            if (c == '(') {sulkuja++;}
            if (c == ')') {sulkuja--;}
            
            //Tai-merkin kohdalla aloitetaan uusi osa jos se ei ole avointen sulkujen sisällä
            if (c == '|' && sulkuja == 0) {
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
            lauseke.lisaaAlkuun(vaihtoehto.kloonaa());
            
            //Jos jokin vaihtoehto toimii, palauta true
            if (tarkasta(syote.kloonaa(), lauseke.kloonaa())) {
                return true;
            }
            
            //Poista tämä vaihtoehto jos se ei toiminut
            lauseke.poista(vaihtoehto.length());
        }
        
        //Jos yksikään vaihtoehto ei toiminut, hylkää
        return false;
        
    }
    
    /**
     * Lisää kaikki turhat sulut siten, että konkatenaatiota tehdään vain sulkulauseille
     * @param m 
     * @return 
     */
    private Merkkijono lisaaSulut(Merkkijono m) {
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
    
    /**
     * Etsi seuraava sulkulause
     * @param m Merkkijono josta etsitään
     * @return 
     */
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
    
    private boolean onErikoismerkki(char c) {
        return c == '*' || c == '|' || c == '(' || c == ')';
    }
}

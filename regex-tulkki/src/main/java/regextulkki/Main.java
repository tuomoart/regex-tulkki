package regextulkki;

import domain.Merkkijono;
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
//        String syote = "aaa";
//        String lauseke = "(a)+";
//        
//        Translator tulkki = new Translator();
//        
//        if (tulkki.matches(syote, lauseke)) {
//            System.out.println("Kuuluu");
//        } else {
//            System.out.println("Ei kuulu");
//        }
        
        Merkkijono m = new Merkkijono("aaaa");
        System.out.println(m.toString());
        m.poista1();
        System.out.println(m.toString());
    }
}

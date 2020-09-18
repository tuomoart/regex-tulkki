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
        String syote = "aa";
        String lauseke = "a+";
        
        Translator tulkki = new Translator();
        
        if (tulkki.matches(syote, lauseke)) {
            System.out.println("Kuuluu");
        } else {
            System.out.println("Ei kuulu");
        }
    }
}

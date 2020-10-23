package regextulkki;

import tietorakenteet.Merkkijono;
import domain.Translator;
import java.util.Scanner;
import ui.Cli;
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
        Cli ui = new Cli(new Scanner(System.in), new Translator());
        
        ui.kaynnista();
    }
}

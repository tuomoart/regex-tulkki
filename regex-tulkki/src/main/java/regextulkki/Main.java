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
    public static void main(String[] args) {
        String syote = "aaaaaaaaaa";
        String lauseke = "a*";
        
        char[] syoteChars = syote.toCharArray();
        char[] lausekeChars = lauseke.toCharArray();
        
        boolean kuuluu = true;
        int syoteOffset = 0;
        
        for (int i = 0; i<lausekeChars.length && i+syoteOffset<syoteChars.length; i++) {
            if (lausekeChars[i]=='*') {
                while (i+syoteOffset<syoteChars.length && syoteChars[i+syoteOffset]==lausekeChars[i-1]) {
                    syoteOffset++;
                }
            }
            
            if (i+syoteOffset >= syoteChars.length) {
                break;
            }
            
            if (syoteChars[i+syoteOffset]!=lausekeChars[i]) {
                kuuluu = false;
                break;
            }
        }
        
        System.out.println(kuuluu);
    }
}

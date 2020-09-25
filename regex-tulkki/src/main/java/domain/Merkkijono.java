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
public class Merkkijono {
    private char[] merkit;
    
    public Merkkijono(char[] merkit) {
        this.merkit = merkit;
    }
    
    public Merkkijono(String merkit) {
        this.merkit = new char[0];
        
        for (char c: merkit.toCharArray()) {
            lisaa(c);
            System.out.println(Arrays.toString(this.merkit));
        }
    }
    
    public Merkkijono(char c) {
        this.merkit = new char[] {c};
    }
    
    public void lisaa(char m) {
        kopioiVoid(1);
        
        merkit[merkit.length-1] = m;
    }
    
    public char[] kopioi(int pidempi) {
        kopioiVoid(pidempi);
        
        return merkit;
    }
    
    public void kopioiVoid(int pidempi) {
        char[] temp = new char[merkit.length + pidempi];
        
        for (int i = 0; i < merkit.length; i++) {
            temp[i] = merkit[i];
        }
        
        merkit = temp;
    }
    
    public char[] poista(int maara) {
        char[] temp = new char[merkit.length-maara];
        
        for (int i = maara; i < merkit.length; i++) {
            temp[i - maara] = merkit[i];
        }
        
        merkit = temp;
        
        return merkit;
    }
    
    public char[] poista1() {
        return poista(1);
    }
    
    public char get(int indeksi) {
        return merkit[indeksi];
    }
    
    public char[] getAll() {
        return merkit;
    }
    
    public int length() {
        return this.merkit.length;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Merkkijono other = (Merkkijono) obj;
        if (!Arrays.equals(this.merkit, other.merkit)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "";
        
        for (char c: merkit) {
            s = s+c;
        }
        
        return s;
    }
    
}

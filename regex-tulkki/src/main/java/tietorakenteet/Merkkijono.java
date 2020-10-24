/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteet;

import java.util.Arrays;

/**
 *
 * @author tuomoart
 */
public class Merkkijono {
    private char[] merkit;
    private int alku = 0;
    private int koko;
    
    public Merkkijono() {
        this.merkit = new char[1];
        this.koko = 0;
    }
    
    public Merkkijono(char c) {
        this.merkit = new char[] {c};
        this.koko = 1;
    }
    
    public Merkkijono(char[] c) {
        this.merkit = c;
        this.koko = c.length;
    }
    
    public Merkkijono(String s) {
        this();
        
        for (char c: s.toCharArray()) {
            lisaa(c);
        }
    }
    
    public void lisaa (char c) {
        if (taynna()) {
            tuplaa();
        }
        
        this.merkit[koko] = c;
        koko++;
    }
    
    public void lisaaAlkuun(Merkkijono m) {
        for (char c : this.getAll()) {
            m.lisaa(c);
        }
        
        this.merkit = m.getAll();
        alku = 0;
        koko = this.merkit.length;
    }
    
    public void poista(int maara) {
        this.alku += maara;
    }
    
    public void poista1() {
        poista(1);
    }
    
    public char get(int i) {
        return this.merkit[alku + i];
    }
    
    public char[] getAll() {
        char[] temp = new char[this.length()];
        
        for (int i = 0; i < this.length(); i++) {
            temp[i] = this.get(i);
        }
        
        return temp;
    }
    
    public int length() {
        return this.koko - this.alku;
    }
    
    public Merkkijono kloonaa() {
        return new Merkkijono(this.getAll());
    }
    
    private boolean taynna() {
        return this.koko == this.merkit.length;
    }
    
    private void tuplaa() {
        char[] temp = new char[this.merkit.length * 2];
        
        for (int i = 0; i < this.merkit.length; i++) {
            temp[i] = this.merkit[i];
        }
        
        this.merkit = temp;
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
        
        for (char c: this.getAll()) {
            s = s + c;
        }
        
        return s;
    }
}

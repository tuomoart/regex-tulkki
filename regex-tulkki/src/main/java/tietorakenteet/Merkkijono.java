/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteet;

/**
 * Luokka merkkijonojen käsittelyyn
 * @author tuomoart
 */
public class Merkkijono {
    private char[] merkit;
    private int alku = 0;
    private int koko;
    
    /**
     * Luo uusi tyhjä Merkkijono
     */
    public Merkkijono() {
        this.merkit = new char[1];
        this.koko = 0;
    }
    
    /**
     * Luo uusi Merkkijono, jossa on yksi merkki
     * @param c lisättävä merkki
     */
    public Merkkijono(char c) {
        this.merkit = new char[] {c};
        this.koko = 1;
    }
    
    /**
     * Uusi Merkkijono merkkitaulukosta
     * @param c taulukko, joka sisältää merkkejä
     */
    public Merkkijono(char[] c) {
        this.merkit = c;
        this.koko = c.length;
    }
    
    
    /**
     * Uusi Merkkijono String-merkkijonosta. Käytetään vain alussa kun siirrytään käyttämään omaa tietorakennetta.
     * @param s String-merkkijono
     */
    public Merkkijono(String s) {
        this();
        
        for (int i = 0; i < s.length(); i++) {
            lisaa(s.charAt(i));
        }
    }
    
    /**
     *  Lisää merkki Merkkijonon loppuun
     * @param c lisättävä merkki
     */
    public void lisaa (char c) {
        if (taynna()) {
            tuplaa();
        }
        
        this.merkit[koko] = c;
        koko++;
    }
    
    /**
     * Lisää toinen Merkkijono tämän Merkkijonon alkuun
     * @param m lisättävä Merkkijono
     */
    public void lisaaAlkuun(Merkkijono m) {
        for (char c : this.getAll()) {
            m.lisaa(c);
        }
        
        this.merkit = m.getAll();
        alku = 0;
        koko = this.merkit.length;
    }
    
    /**
     * Poista Merkkijonon alusta merkkejä
     * @param maara poistettavien merkkien määrä
     */
    public void poista(int maara) {
        this.alku += maara;
    }
    
    /**
     * Poista yksi merkki alusta
     */
    public void poista1() {
        poista(1);
    }
    
    /**
     * Nouda merkki indeksillä
     * @param i indeksi
     * @return merkki kohdassa i
     */
    public char get(int i) {
        return this.merkit[alku + i];
    }
    
    /**
     * Nouda kaikki Merkkijonon merkit merkkitaulukkona
     * @return kaikki merkit taulukkona
     */
    public char[] getAll() {
        char[] temp = new char[this.length()];
        
        for (int i = 0; i < this.length(); i++) {
            temp[i] = this.get(i);
        }
        
        return temp;
    }
    
    /**
     * Merkkijonon pituus
     * @return pituus
     */
    public int length() {
        return this.koko - this.alku;
    }
    
    /**
     * Luo erillinen kopio
     * @return uusi Merkkijono-olio samalla sisällöllä
     */
    public Merkkijono kloonaa() {
        return new Merkkijono(this.getAll());
    }
    
    //Tarkasta, onko taulukko täynnä, jotta tiedetään kasvattaa sitä tarvittaessa
    private boolean taynna() {
        return this.koko == this.merkit.length;
    }
    
    //Tuplaa taulukon koko
    private void tuplaa() {
        char[] temp = new char[this.merkit.length * 2];
        
        for (int i = 0; i < this.merkit.length; i++) {
            temp[i] = this.merkit[i];
        }
        
        this.merkit = temp;
    }
    
    /**
     * Tarpeeton, luotu IDE:n herjojen poistamiseksi equals-metodin käyttöä varten.
     * @return 
     */
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
        
        if (this.merkit.length != other.merkit.length) {
            return false;
        }
        
        for (int i = 0; i < this.merkit.length; i++) {
            if (this.merkit[i] != other.merkit[i]) {
                return false;
            }
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

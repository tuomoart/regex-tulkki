package tietorakenteet;

/**
 * Lista Merkkijonojen säilyttämiseen
 * @author tuomoart
 */
public class Lista {
    private Merkkijono[] lista;
    private int koko;
    
    /**
     * Luo uusi tyhjä lista
     */
    public Lista() {
        lista = new Merkkijono[1];
        koko = 0;
    }
    
    /**
     * Ĺistan pituus
     * @return pituus
     */
    public int size() {
        return koko;
    }
    
    /**
     * Lisää uusi kohde listalle
     * @param m Lisättävä merkkijono
     */
    public void add(Merkkijono m) {
        if (this.taynna()) {
            this.tuplaa();
        }
        
        lista[koko] = m;
        koko++;
    }
    
    /**
     * Nouda listalta indeksillä
     * @param i indeksi
     * @return Merkkijono kohdassa i
     */
    public Merkkijono get(int i) {
        if (i >= koko) {
            return new Merkkijono();
        }
        
        return lista[i];
    }
    
    //Tuplaa listan koko
    private void tuplaa() {
        Merkkijono[] temp = new Merkkijono[lista.length*2];
        
        for (int i = 0; i < lista.length; i++) {
            temp[i] = lista[i];
        }
        
        lista = temp;
    }
    
    //Tarkasta, onko taulukko täynnä, jotta tiedetään suurentaa tarvittaessa.
    private boolean taynna() {
        return koko == lista.length;
    }
}

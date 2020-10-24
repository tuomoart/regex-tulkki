package tietorakenteet;

/**
 *
 * @author tuomoart
 */
public class Lista {
    private Merkkijono[] lista;
    private int koko;
    
    public Lista() {
        lista = new Merkkijono[1];
        koko = 0;
    }
    
    public int size() {
        return koko;
    }
    
    public void add(Merkkijono m) {
        if (this.taynna()) {
            this.tuplaa();
        }
        
        lista[koko] = m;
        koko++;
    }
    
    public Merkkijono get(int i) {
        if (i >= koko) {
            return new Merkkijono();
        }
        
        return lista[i];
    }
    
    private void tuplaa() {
        Merkkijono[] temp = new Merkkijono[lista.length*2];
        
        for (int i = 0; i < lista.length; i++) {
            temp[i] = lista[i];
        }
        
        lista = temp;
    }
    
    private boolean taynna() {
        return koko == lista.length;
    }
}

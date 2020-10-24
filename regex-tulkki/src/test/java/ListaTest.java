/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tietorakenteet.Lista;
import tietorakenteet.Merkkijono;

/**
 *
 * @author tuomoart
 */
public class ListaTest {
    private Lista l;
    
    public ListaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.l = new Lista();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriTest() {
        Lista l = new Lista();
        
        assertEquals(0, l.size());
    }
    
    @Test
    public void addTest() {
        assertEquals(0, l.size());
        
        l.add(new Merkkijono('a'));
        assertEquals(1, l.size());
        assertEquals('a', l.get(0).get(0));
    }
    
    @Test
    public void tyhjastaHakuPalauttaaTyhjanMjonon() {
        assertEquals(0, l.get(0).length());
    }
    
    @Test
    public void liianIsoIndeksiPalauttaaTyhjanMjonon() {
        l.add(new Merkkijono("a"));
        
        assertEquals(0, l.get(1).length());
    }
    
    @Test
    public void kokoKasvaaOikein() {
        for (int i = 1; i < 11; i++) {
            l.add(new Merkkijono('a'));
            assertEquals(i, l.size());
        }
        
    }
    
    
}

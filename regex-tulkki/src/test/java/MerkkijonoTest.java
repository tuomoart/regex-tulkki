/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Merkkijono;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tuomoart
 */
public class MerkkijonoTest {
    
    public MerkkijonoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void stringKonstruktoriTesti() {
        String s = "abc";
        
        Merkkijono m = new Merkkijono(s);
        
        Assert.assertArrayEquals(s.toCharArray(), m.getAll());
    }

    @Test
    public void charKonstruktoriTesti() {
        char c = 'a';
        
        Merkkijono m = new Merkkijono(c);
        
        Assert.assertArrayEquals(new char[] {c}, m.getAll());
    }

    @Test
    public void charArrayKonstruktoriTesti() {
        String s = "abc";
        
        Merkkijono m = new Merkkijono(s.toCharArray());
        
        Assert.assertArrayEquals(s.toCharArray(), m.getAll());
    }
    
    @Test
    public void poista1Test() {
        Merkkijono m = new Merkkijono("abc");
        m.poista1();
        Assert.assertArrayEquals("bc".toCharArray(), m.getAll());
    }
    
    @Test
    public void getTest() {
        Merkkijono m = new Merkkijono("abc");
        assertEquals('a', m.get(0));
        assertEquals('b', m.get(1));
        assertEquals('c', m.get(2));
    }
    
    @Test
    public void equalsTest() {
        Merkkijono m1 = new Merkkijono("abc");
        Merkkijono m2 = new Merkkijono("abc");
        Merkkijono m3 = new Merkkijono("uio");
        String s = "abc";
        
        assertEquals(true, m1.equals(m1));
        assertEquals(true, m1.equals(m2));
        assertEquals(false, m1.equals(m3));
        assertEquals(false, m1.equals(s));
        assertEquals(false, m1.equals(null));
    }
    
    @Test
    public void hashCodeTest() {
        //Tätä ei tarvita mihinkään mutta testataan jottei näy rumasti testikattavuusraportissa.
        Merkkijono m = new Merkkijono("");
        
        assertEquals(7, m.hashCode());
    }
}

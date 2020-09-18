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
import domain.Translator;

/**
 *
 * @author tuomoart
 */
public class TranslatorTest {
    private Translator t;
    
    public TranslatorTest() {
        t = new Translator();
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void singleCharacterTest1() {
        assertEquals(true, t.matches("a", "a"));
    }
    
    @Test
    public void singleCharacterTest2() {
        assertEquals(false, t.matches("b", "a"));
    }
    
    @Test
    public void singleCharacterTest3() {
        assertEquals(false, t.matches("", "a"));
    }
    
    @Test
    public void repetitionTest1() {
        assertEquals(true, t.matches("aaa", "a*"));
    }
    
    @Test
    public void repetitionTest2() {
        assertEquals(false, t.matches("aab", "a*"));
    }
    
    @Test
    public void repetitionTest3() {
        assertEquals(true, t.matches("", "a*"));
    }
    
    @Test
    public void repetitionTest4() {
        assertEquals(true, t.matches("b", "a*b"));
    }
    
    @Test
    public void repetitionTest5() {
        assertEquals(true, t.matches("c", "a*b*c"));
    }
    
    @Test
    public void repetitionTest6() {
        assertEquals(true, t.matches("ccc", "a*b*c*"));
    }
    
    @Test
    public void repetitionTest7() {
        assertEquals(true, t.matches("aaabbc", "a*b*c"));
    }
    
}

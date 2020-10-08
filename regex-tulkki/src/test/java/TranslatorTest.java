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
    
    @Test
    public void parenthesisTest1() {
        assertEquals(true, t.matches("a", "(a|b)"));
    }
    
    @Test
    public void parenthesisTest2() {
        assertEquals(true, t.matches("c", "(a|b|c)"));
    }
    
    @Test
    public void parenthesisTest3() {
        assertEquals(true, t.matches("aa", "(aa)*"));
        assertEquals(true, t.matches("aaaa", "(aa)*"));
    }
    
    @Test
    public void parenthesisTest4() {
        assertEquals(false, t.matches("aaa", "(aa)*"));
    }
    
    @Test
    public void parenthesisTest5() {
        assertEquals(true, t.matches("ab", "(ab)*"));
        assertEquals(true, t.matches("abab", "(ab)*"));
        assertEquals(false, t.matches("abc", "(ab)*"));
    }
    
    @Test
    public void parenthesisTest6() {
        assertEquals(true, t.matches("acccaabbba", "(a(c|b)*a)*"));
    }
    
    
}

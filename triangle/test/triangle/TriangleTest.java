package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**
 * Test class for the Triangle implementation.
 */
public class TriangleTest {

    @Test
    public void test1() {
        Type actual = Triangle.classify(10, 10, 10);
        Type expected = EQUILATERAL;
        assertEquals(actual, expected);
    }
    
    public void test_statement() {
    	
    }
    
    public void test_condition() {
    	
    }
    
    public void test_mutation() {
    	
    }
    
}

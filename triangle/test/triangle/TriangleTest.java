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
        Type expected;
        Type actual;
        
        //Tests 'false' for all conditions in line 20
        expected = INVALID;
        actual = Triangle.classify(0,0,0);
        assertEquals(actual, expected);
        
        //Tests 'true' for lines 24, 27, 30
        //Tests 'false' for line 33
        //Tests 'true' for line 40
        expected = EQUILATERAL;
        actual = Triangle.classify(1,1,1);
        assertEquals(actual, expected);
        
        //Test true and false for all conditions in line 34. 
        //Tests 'true' for line 20 conditions
        //Tests 'false' for lines 24, 27, 30, 33
        expected = INVALID;
        actual = Triangle.classify(1, 2, 3);
        assertEquals(actual, expected);
        
        expected = INVALID;
        actual = Triangle.classify(2, 3, 1);
        assertEquals(actual, expected);
        
        expected = INVALID;
        actual = Triangle.classify(3, 1 ,2);
        assertEquals(actual, expected);
        
        //train = 1
        
        
        //train = 2
        
        
        //train = 3
    	
    }
    
    public void test_mutation() {
    	
    }
    
}

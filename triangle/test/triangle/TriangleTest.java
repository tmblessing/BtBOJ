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
    
    @Test
    public void test_statement() {
    	
    	
    	//Test an invalid triangle condition
    	Type actual = Triangle.classify(0,0,0);
    	Type expected = INVALID;
    	assertEquals(actual, expected);
    	
    	actual = Triangle.classify(1,1,1);
    	
    	expected = EQUILATERAL;
    	
    	assertEquals(actual,expected);
    	
    }
    
    @Test
    public void test_cond_invalid(){
    	int a = 0;
    	int b = 0;
    	int c = 0; 
    	
    	//Test a non-existent triangle
    	Type actual = Triangle.classify(a,b,c);
    	Type expected = INVALID;
    	assertEquals(actual, expected);
    	
    	a = 10;
    	b = 10;
    	
    	//test incase of impossible Triangle dimensions
    	actual = Triangle.classify(a,b,c);
    	assertEquals(actual,expected);
    	
    }
    
    @Test
    public void test_cond_scalene() {
    	Type actual = Triangle.classify(3,5,6);
    	Type expected = SCALENE;
    	
    	assertEquals(actual,expected);
    	
    	
    }
    
    public void test_condition() {
    	
    }
    
    public void test_mutation() {
    	
    }
    
}

package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**
 * Test class for the Triangle implementation.
 */
public class TriangleTest {

	
	//Coverage Tests
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
    public void test_state_invalid(){
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
    	
    	c = 200;
    	
    	actual = Triangle.classify(a,b,c);
    	
    	assertEquals(actual,expected);
    	
    }
    
    @Test
    public void test_state_scalene() {
    	Type actual = Triangle.classify(3,5,6);
    	Type expected = SCALENE;
    	
    	assertEquals(actual,expected);
    	
    }
    
    
    @Test
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
        
         //'true' for both conditionals in line 43
        expected = ISOSCELES;
        actual = Triangle.classify(2, 2, 1);
        assertEquals(actual, expected);
        
        //'true' for both conditionals in line 45 (and false for first condition of 43)
        expected = ISOSCELES;
        actual = Triangle.classify(2, 1, 2);
        assertEquals(actual, expected);
        
        //'true' for both conditionals in line 47
        expected = ISOSCELES;
        actual = Triangle.classify(1, 2, 2);
        assertEquals(actual, expected);
    	
        //'false' for all conditionals in line 43, 45, and 47 (except first condition of 43)
        expected = INVALID;
        actual = Triangle.classify(Integer.MAX_VALUE, Integer.MIN_VALUE, 10);
        assertEquals(actual, expected);
    	
    }
    
    public class TriangleTestMutant {

        @Test
        //5,10,14,19,23,41,44,45,49,50,51,52,54,55,56,60,97,98
        //total:18
        public void test1() {
            Type actual = Triangle.classify(10, 10, 10);
            Type expected = EQUILATERAL;
            assertEquals(actual, expected);

        }

        @Test
        //for mutation 1,6,15
        //total:3
        public void testMut1() {
            Type actual = Triangle.classify(1, 1, 1);
            Type expected = Type.EQUILATERAL;
            assertEquals(actual, expected);
            
        }
        
        @Test
        //for mutation 2,3,13,22,24
        //total:5
        public void testMut2() {
            Type actual = Triangle.classify(0, 2, 2);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 4
        //total:1
        public void testMut4() {
            Type actual = Triangle.classify(-1, 2, 2);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 7,8,12
        //total: 3
        public void testMut7() {
            Type actual = Triangle.classify(2, 0, 2);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 9
        //total:1
        public void testMut9() {
            Type actual = Triangle.classify(2, -1, 2);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }


        // mutation 11, have the result of Type.INVALID,
        //even though true, true, false can break the first if loop

        // $ ./show_mutant.sh 11
        // --- src/triangle/Triangle.java  2018-10-23 10:13:45.058122400 -0400
        // +++ .mutated/mutants/11/triangle/Triangle.java  2018-10-23 10:13:44.368538900 -0400
        // @@ -20 +20 @@
        // -        if (a <= 0 || b <= 0 || c <= 0) {
        // +        if (a <= 0 != b <= 0 || c <= 0) {



        @Test
        //for mutation 16,17,21
        //total:3
        public void testMut16() {
            Type actual = Triangle.classify(2, 2, 0);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 18
        //total:1
        public void testMut18() {
            Type actual = Triangle.classify(2, 2, -1);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 20
        //total:1
        public void testMut20() {
            Type actual = Triangle.classify(0, -1, 0);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 25,37,47,93,94, 95,108,113,118,131, 135,148,150
        //total:13
        public void testMut25() {
            Type actual = Triangle.classify(2, 2, 6);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 26,27,57,58,61, 62,64,65,68,69, 71,72,75,79,82, 83,86,90,92
        //total:19
        public void testMut26() {
            Type actual = Triangle.classify(3, 4, 5);
            Type expected = Type.SCALENE;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 28,38,48,80
        //total:4
        public void testMut28() {
            Type actual = Triangle.classify(4, 3, 2);
            Type expected = Type.SCALENE;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 29,30,31,32,33, 34,35,36,99,100, 103,104,106,107,110, 112,115
        //total:17
        public void testMut29() {
            Type actual = Triangle.classify(2, 2, 3);
            Type expected = Type.ISOSCELES;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 39,40,42,43,46, 116,117,120,121,123, 124,127,129,132
        //total:14
        public void testMut39() {
            Type actual = Triangle.classify(4, 3, 4);
            Type expected = Type.ISOSCELES;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 53,96,133,134,137, 138,140,141,144,146, 149
        //total: 11
        public void testMut53() {
            Type actual = Triangle.classify(2, 3, 3);
            Type expected = Type.ISOSCELES;
            assertEquals(actual, expected);
            
        }

        
        //for mutation 59, it won't be able to fail, since
        //trian won't be able to be negative

        // $ ./show_mutant.sh 59
        // --- src/triangle/Triangle.java  2018-10-23 10:13:45.058122400 -0400
        // +++ .mutated/mutants/59/triangle/Triangle.java  2018-10-23 10:13:44.647443200 -0400
        // @@ -33 +33 @@
        // -        if (trian == 0) {
        // +        if (trian <= 0) {

        @Test
        //for mutation 63,67,78,89,91
        //total: 5
        public void testMut63() {
            Type actual = Triangle.classify(2, 5, 9);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 66
        //total: 1
        public void testMut66() {
            Type actual = Triangle.classify(1, 2, 3);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 70,74,77
        //total: 3
        public void testMut70() {
            Type actual = Triangle.classify(2, 9, 5);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 73
        //total: 1
        public void testMut73() {
            Type actual = Triangle.classify(1, 3, 2);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        //for mutation 76, the only way to break this is true,true,false, but
        //a + b <= c and a + c <= b cannot happen at the same time, and a>0,b>0,c>0, then 
        //it won't be fail
        // $ ./show_mutant.sh 76
        // --- src/triangle/Triangle.java  2018-10-23 10:13:45.058122400 -0400
        // +++ .mutated/mutants/76/triangle/Triangle.java  2018-10-23 10:13:44.707887300 -0400
        // @@ -34 +34 @@
        // -            if (a + b <= c || a + c <= b || b + c <= a) {
        // +            if (a + b <= c != a + c <= b || b + c <= a) {


        @Test
        //for mutation 81,85,88
        //total: 3
        public void testMut81() {
            Type actual = Triangle.classify(9, 2, 5);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 84
        //total: 1
        public void testMut84() {
            Type actual = Triangle.classify(3, 1, 2);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        //for mutation 87, it won't be able to let a+c<=b and b+c<=a at the same time,
        //since the values are positive, and only true and true condition can result two different results 
        // $ ./show_mutant.sh 87
        // --- src/triangle/Triangle.java  2018-10-23 10:13:45.058122400 -0400
        // +++ .mutated/mutants/87/triangle/Triangle.java  2018-10-23 10:13:44.747528900 -0400
        // @@ -34 +34 @@
        // -            if (a + b <= c || a + c <= b || b + c <= a) {
        // +            if ((a + b <= c || a + c <= b) != b + c <= a) {



        //for mutation 101, since the value of trian cannot be less than 1, since
        //all have been detected
        // $ ./show_mutant.sh 101
        // --- src/triangle/Triangle.java  2018-10-23 10:13:45.058122400 -0400
        // +++ .mutated/mutants/101/triangle/Triangle.java 2018-10-23 10:13:44.327467100 -0400
        // @@ -43 +43 @@
        // -        if (trian == 1 && a + b > c) {
        // +        if (trian <= 1 && a + b > c) {

        @Test
        //for mutation 102,114,119,142,147
        //total: 5
        public void testMut102() {
            Type actual = Triangle.classify(7, 1, 1);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 105
        //total: 1
        public void testMut105() {
            Type actual = Triangle.classify(3, 3, 7);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 109
        //total: 1
        public void testMut109() {
            Type actual = Triangle.classify(1, 1, 2);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        //for mutation 111, the only way to get different result is to have false,false condiction,
        //since all values are not negative, then it won't be able to fail
        // $ ./show_mutant.sh 111
        // --- src/triangle/Triangle.java  2018-10-23 10:13:45.058122400 -0400
        // +++ .mutated/mutants/111/triangle/Triangle.java 2018-10-23 10:13:44.376895200 -0400
        // @@ -43 +43 @@
        // -        if (trian == 1 && a + b > c) {
        // +        if (trian == 1 == a + b > c) {


        @Test
        //for mutation 122,125,130
        //total: 3
        public void testMut122() {
            Type actual = Triangle.classify(3, 7, 3);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        @Test
        //for mutation 126
        //total: 1
        public void testMut126() {
            Type actual = Triangle.classify(1, 2, 1);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        // for mutation 128, the only way to get different result is to have false,false condiction,
        //since all values are not negative, then it won't be able to fail
        // $ ./show_mutant.sh 128
        // --- src/triangle/Triangle.java  2018-10-23 10:13:45.058122400 -0400
        // +++ .mutated/mutants/128/triangle/Triangle.java 2018-10-23 10:13:44.441360600 -0400
        // @@ -45 +45 @@
        // -        } else if (trian == 2 && a + c > b) {
        // +        } else if (trian == 2 == a + c > b) {


        //for mutation 136, since the value of trian cannot be greater than 3, since
        //all have been detected
        // $ ./show_mutant.sh 136
        // --- src/triangle/Triangle.java  2018-10-23 10:13:45.058122400 -0400
        // +++ .mutated/mutants/136/triangle/Triangle.java 2018-10-23 10:13:44.460463000 -0400
        // @@ -47 +47 @@
        // -        } else if (trian == 3 && b + c > a) {
        // +        } else if (trian >= 3 && b + c > a) {

     
        @Test
        //for mutation 139
        //total: 1
        public void testMut139() {
            Type actual = Triangle.classify(7, 3, 3);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }


        @Test
        //for mutation 143
        //total: 1
        public void testMut143() {
            Type actual = Triangle.classify(2, 1, 1);
            Type expected = Type.INVALID;
            assertEquals(actual, expected);
            
        }

        // for mutation 145, the only way to get different result is to have false,false condiction,
        //since all values are not negative, then it won't be able to fail
        // $ ./show_mutant.sh 145
        // --- src/triangle/Triangle.java  2018-10-23 10:13:45.058122400 -0400
        // +++ .mutated/mutants/145/triangle/Triangle.java 2018-10-23 10:13:44.487581200 -0400
        // @@ -47 +47 @@
        // -        } else if (trian == 3 && b + c > a) {
        // +        } else if (trian == 3 == b + c > a) {

    
    }
}

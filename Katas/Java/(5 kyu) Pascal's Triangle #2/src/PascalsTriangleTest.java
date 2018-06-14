import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

import org.testng.annotations.Test;

public class PascalsTriangleTest {

    @Test
    public void test1() {
        assertArrayEquals( "Depth 1 should return [ [1] ]",
                new int[][] { {1} },
                PascalsTriangle.pascal(1));
    }

    @Test
    public void test2() {
        assertArrayEquals( new int[][] { {1}, {1,1} },
                PascalsTriangle.pascal(2));
    }

    @Test
    public void test3() {
        assertArrayEquals( new int[][] { {1}, {1,1}, {1,2,1} },
                PascalsTriangle.pascal(3));
    }


    @Test
    public void test5() {
        assertArrayEquals("Depth 5 should return [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]",
                new int[][] { {1}, {1,1}, {1,2,1}, {1,3,3,1}, {1,4,6,4,1} },
                PascalsTriangle.pascal(5));
    }
}
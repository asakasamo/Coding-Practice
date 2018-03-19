import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class SolutionTest {
    @Test
    public void testNormalCondition() {
        assertEquals(9, Solution.solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(0, Solution.solveSuperMarketQueue(new int[] {}, 1));
    }

    @Test
    public void testSingleTillManyCustomers() {
        assertEquals(15, Solution.solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1));
    }

    @Test
    public void testFreeLine() {
        assertEquals(-1, Solution.freeLine(new int[] {1,1,1}));
        assertEquals(1, Solution.freeLine(new int[] {1,0,1}));
        assertEquals(2, Solution.freeLine(new int[] {1,1,0}));
        assertEquals(0, Solution.freeLine(new int[] {0,1,0}));
    }

    @Test
    public void testMixedCondition() {
        assertEquals(11, Solution.solveSuperMarketQueue(new int[] {5,2,1,5,3,6}, 3));
    }

    @Test
    public void testMixedCondition2() {
        assertEquals(13, Solution.solveSuperMarketQueue(new int[] {1,2,3,4,1,7,1,8,7,2,9,3}, 5));
    }

}
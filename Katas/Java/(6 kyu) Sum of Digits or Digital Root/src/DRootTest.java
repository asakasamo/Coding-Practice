import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertEquals;

public class DRootTest {
    @Test
    public void Tests() {
        assertEquals( "Nope!" , DRoot.digital_root(16), 7);
    }

    @Test
    public void test1() {
        assertEquals(DRoot.digital_root(942), 6);
    }

    @Test
    public void test2() {
        assertEquals(DRoot.digital_root(132189), 6);
    }
}
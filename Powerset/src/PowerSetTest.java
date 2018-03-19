import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Al-John
 */
class PowerSetTest {
    @Test
    public void testPowerset1Element() {

        Integer[] set = new Integer[] {5};

        List<List<Integer>> actualPowerSet = new ArrayList();
        actualPowerSet.add(toList());
        actualPowerSet.add(toList(5));

        assertEquals(actualPowerSet, PowerSet.getPowerSet(set));
    }

    private <E> List<E> toList(E... elements) {
        return Arrays.asList(elements);
    }

    @Test
    public void testPowerset2Elements() {
        String[] set = {"fizz", "buzz"};

        List<List<String>> actualPowerSet = new ArrayList();
        actualPowerSet.add(toList());
        actualPowerSet.add(toList("buzz"));
        actualPowerSet.add(toList("fizz"));
        actualPowerSet.add(toList("fizz", "buzz"));

        assertEquals(actualPowerSet, PowerSet.getPowerSet(set));
    }

    @Test
    public void testPowerset3Elements() {
        Integer[] set = {1, 2, 3};

        List<List<Integer>> actualPowerSet = new ArrayList();
        actualPowerSet.add(toList());
        actualPowerSet.add(toList(3));
        actualPowerSet.add(toList(2));
        actualPowerSet.add(toList(2, 3));
        actualPowerSet.add(toList(1));
        actualPowerSet.add(toList(1, 3));
        actualPowerSet.add(toList(1, 2));
        actualPowerSet.add(toList(1, 2, 3));

        assertEquals(actualPowerSet, PowerSet.getPowerSet(set));
    }

    @Test
    public void testGetBitCount() {
        assertEquals(4, PowerSet.getBitCount(10));
        assertEquals(7, PowerSet.getBitCount(99));
    }

    @Test
    public void testGetBinaryStrings() {
        assertArrayEquals( new String[] {"000", "001", "010", "011", "100", "101"},
                PowerSet.getBinaryStrings(5));
    }

    @Test
    public void testPowersetLotsaElements() {

        int elements = 25;

        Integer[] set = new Integer[elements];
        for(int i = 0; i < elements; i++)
            set[i] = i;

        List<List<Integer>> powerSet = PowerSet.getPowerSet(set);
        System.out.println(powerSet);
    }
}
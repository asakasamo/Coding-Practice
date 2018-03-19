import java.util.ArrayList;
import java.util.List;

/**
 * @author Al-John
 */
public class PowerSet {

    /**
     * Returns the power set of a given set (i.e. the set of all subsets)
     * @param set the set
     * @param <E> the type of elements in the set
     * @return the power set
     */
    public static<E> List<List<E>> getPowerSet (E[] set) {

        List<List<E>> powerSet = new ArrayList<>();
        int subsets = (int)Math.pow(2, set.length) -1;
        int bits = getBitCount(subsets);
        String[] binaryStrings = getBinaryStrings(subsets);

        for(int i = 0; i < binaryStrings.length; i++) {
            powerSet.add(new ArrayList<>());

            for(int bit = 0; bit < bits; bit++) {
                if(binaryStrings[i].charAt(bit) == '1')
                    powerSet.get(i).add(set[bit]);
            }
        }

        return powerSet;
    }

    /**
     * Returns an array of Strings that are the binary representation of each index, from 0 to a given upper bound.
     * Each binary string will contain the same number of bits as the upper bound.
     *
     * @param high the upper bound
     * @return the the binary strings from 0 to high
     */
    public static String[] getBinaryStrings(int high) {
        int bits = getBitCount(high);
        String[] binaryStrings = new String[high + 1];

        for(int i = 0; i <= high; i++) {
            String binaryString = Integer.toBinaryString(i);
            int remainingBits = bits - binaryString.length();
            for(int n = 0; n < remainingBits; n++)
                binaryString = "0" + binaryString;
            binaryStrings[i] = binaryString;
        }

        return binaryStrings;
    }

    /**
     * Returns the number of bits required to represent a specified number in binary.
     * @param number the specified number
     * @return the number of bits required to represent the number in binary
     */
    public static int getBitCount(int number) {
        int bits = 0;
        for(int i = number; i != 0; i/=2)
            bits++;
        return bits;
    }
}

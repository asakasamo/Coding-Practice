/**
 * @author Al-John
 */
public class NumberFun {
    public static long findNextSquare(long sq) {

        double root = Math.sqrt(sq);
        if(root - (long)root > 0)
            return -1;

        return (long)Math.pow(root + 1, 2);
    }
}

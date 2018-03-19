/**
 * @author Al-John
 */
public class Triangular {
    public static int triangular(int n) {
        if(n == 1 || n == 0)
            return n;

        if(n < 0)
            return 0;

        return n + triangular(n - 1);
    }
}

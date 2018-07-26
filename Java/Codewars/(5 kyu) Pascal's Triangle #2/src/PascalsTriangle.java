import java.util.Arrays;

/**
 * @author Al-John
 */
public class PascalsTriangle {
    public static int[][] pascal(int depth) {
        int[][] triangle = new int[depth][];

        for(int i = 0; i < depth; i++) {
            triangle[i] = new int[i+1];
            for(int n = 0; n < triangle[i].length; n++){
                if(n == 0 || n == i)
                    triangle[i][n] = 1;
                else
                    triangle[i][n] = triangle[i-1][n-1] + triangle[i-1][n];
            }
        }

        System.out.println(Arrays.deepToString(triangle));

        return triangle;
    }
}

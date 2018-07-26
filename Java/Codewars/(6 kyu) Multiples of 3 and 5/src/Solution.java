import java.util.ArrayList;

/**
 * @author Al-John
 */
public class Solution {
    public int solution(int number) {
        ArrayList<Integer> multiples = new ArrayList<>();

        for(int i = 0; i < number; i++){
            if(i % 3 == 0 || i % 5 == 0)
                multiples.add(i);
        }

        int sum = 0;
        for(int i : multiples)
            sum += i;

        return sum;
    }
}

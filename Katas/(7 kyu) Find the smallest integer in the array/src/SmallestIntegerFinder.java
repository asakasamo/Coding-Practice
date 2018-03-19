/**
 * @author Al-John
 */
public class SmallestIntegerFinder {
    public static int findSmallestInt(int[] args) {
        int smallest = args[0];
        for(int i : args){
            if(i < smallest)
                smallest = i;
        }

        return smallest;
    }
}

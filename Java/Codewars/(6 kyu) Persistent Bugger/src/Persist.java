/**
 * @author Al-John
 */
public class Persist {
    public static int persistence(long n) {
        return persist(n, 0);
    }

    private static int persist(long n, int times){
        String nString = "" + n;

        if(nString.length() == 1)
            return times;

        int next = 1;
        for(int i = 0; i < nString.length(); i++){
            next *= Integer.parseInt(nString.substring(i, i+1));
        }

        return persist(next, times +1);
    }
}

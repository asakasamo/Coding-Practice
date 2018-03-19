import java.util.Arrays;

/**
 * @author Al-John
 */
public class LongestConsec {

    public static String longestConsec(String[] strarr, int k) {

        if(k > strarr.length)
            return "";

        int[] lengths = new int[strarr.length - k +1];

        //store the lengths of k consecutive strings (by starting index)
        for(int i = 0; i < lengths.length; i++) {
            lengths[i] = 0;
            for(int n = i; n < i + k; n++)
                lengths[i] += strarr[n].length();
        }

        int longest = lengths[0];
        int longestIdx = 0;
        for(int i = 1; i < lengths.length; i++) {
            if(lengths[i] > longest){
                longest = lengths[i];
                longestIdx = i;
            }
        }

        String longestString = "";
        for(int i = longestIdx; i < longestIdx + k; i++)
            longestString += strarr[i];

        return longestString;
    }

}

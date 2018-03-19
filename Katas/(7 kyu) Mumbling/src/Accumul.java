/**
 * @author Al-John
 */
public class Accumul {
    public static String accum(String s) {
        return accumulate(s, 1, "");
    }

    private static String accumulate(String remaining, int iteration, String result) {
        //if there are no characters left to repeat
        if(remaining.equals(""))
            return result;

        //next character to repeat
        char repeat = remaining.toLowerCase().charAt(0);

        //if it's the first iteration
        if(result.equals(""))
            return accumulate(remaining.substring(1), iteration +1, "" + Character.toUpperCase(repeat));

        result += "-" + Character.toUpperCase(repeat);
        for(int i = 0; i < iteration -1; i++)
            result += repeat;

        return accumulate(remaining.substring(1), iteration +1, result);
    }
}

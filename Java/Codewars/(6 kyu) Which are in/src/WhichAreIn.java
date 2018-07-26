import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Al-John
 */
public class WhichAreIn {
    public static String[] inArray(String[] array1, String[] array2) {

        ArrayList<String> in = new ArrayList<>();

        for(String string1 : array1)
            for(String string2 : array2)
                if(string2.contains(string1)) {
                    in.add(string1);
                    break;
                }

        System.out.println(in);

        in.sort(Comparator.naturalOrder());

        return in.toArray(new String[in.size()]);
    }
}

/**
 * @author Al-John
 */
public class DRoot {
    public static int digital_root(int n) {
        String number = "" + n;
        if(number.length() == 1)
            return n;
        else {
            int digitalSum = 0;
            for(int i = 0; i < number.length(); i++){
                digitalSum += Integer.parseInt(number.charAt(i) + "");
            }
            return digital_root(digitalSum);
        }
    }
}

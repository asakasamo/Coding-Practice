/**
 * @author Al-John
 */
public class Tortoise {

    public static int[] race(int v1, int v2, int g) {
        if(v1 > v2)
            return null;

        double hoursToCatch = (double)g/(double)(v2 - v1);

        return toHoursMinsSecs(hoursToCatch);
    }

    public static int[] toHoursMinsSecs(double hours) {
        int[] hms = new int[3];
        hms[0] = (int)hours;
        hms[1] = (int)(hours * 60) % 60;
        hms[2] = (int)(hours * 3600) % 60;

        return hms;
    }
}


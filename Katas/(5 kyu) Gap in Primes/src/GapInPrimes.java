import java.util.ArrayList;

/**
 * @author Al-John
 */
public class GapInPrimes {

    public static long[] gap(int g, long m, long n) {
        ArrayList<Long> primesBetween = primesBetween(m, n);
        long gap = 0;

        for(int i = 0; i < primesBetween.size() -1; i++) {
            gap = primesBetween.get(i+1) - primesBetween.get(i);
            if(gap == g)
                return new long[] { primesBetween.get(i) , primesBetween.get(i+1)};
        }

        return null;
    }

    public static ArrayList<Long> primesBetween(long low, long high) {
        ArrayList primes = new ArrayList<>();

        for(long i = low; i <= high; i++) {
            if(isPrime(i))
                primes.add(i);
        }

        return primes;
    }

    public static boolean isPrime(long n) {
        for (long j = 2; j < n / 2; j++) {
            if (n % j == 0) return false;
        }
        return true;
    }
}

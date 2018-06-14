/**
 * @author Al-John
 */
public class Kata {
    public static int TripleDouble(long num1, long num2)
    {
        boolean[] triples = new boolean[10];
        boolean[] doubles = new boolean[10];

        String num1String = "" + num1;
        String num2String = "" + num2;

        //initialize to false
        for(int i = 0; i < 10; i++) {
            triples[i] = false;
            doubles[i] = false;
        }

        //check for triples in num1String
        for(int i = 0; i < num1String.length() - 2; i++){
            if(num1String.charAt(i) == num1String.charAt(i+1) && num1String.charAt(i) == num1String.charAt(i+2))
                triples[Integer.parseInt("" + num1String.charAt(i))] = true;
        }

        //check for doubles in num2String
        for(int i = 0; i < num2String.length() -1; i++) {
            if(num2String.charAt(i) == num2String.charAt(i+1))
                doubles[Integer.parseInt("" + num2String.charAt(i))] = true;
        }

        //check for the tripledoubles
        for(int i = 0; i < 10; i++){
            if(triples[i] == true && doubles[i] == true)
                return 1;
        }

        return 0;
    }
}

import java.util.ArrayList;

/**
 * @author Al-John
 */
public class Solution {

    final static int NO_FREE_LINE = -1;

    public static int solveSuperMarketQueue(int[] customers, int n) {

        int[] tellers = new int[n];
        int nextCustomer = 0;
        int iteration = 0;

        //initialize
        for(int i = 0; i < n; i++) {
            tellers[i] = 0;
        }

        while(nextCustomer <= customers.length || freeLine(tellers) != NO_FREE_LINE) {
            //check for free line
            int freeLine = freeLine(tellers);

            printTellers(tellers);
            System.out.println("Next customer: " + nextCustomer);
            System.out.println("Free line: " + freeLine);
            System.out.println("Iteration: " + iteration);
            System.out.println("- - -");

            //if free line available
            if(freeLine != NO_FREE_LINE && nextCustomer < customers.length) {
                //add customer to free line
                tellers[freeLine] = customers[nextCustomer];
                //move to next customer
                nextCustomer++;
                //check again for this iteration
                continue;
            }
            //if no free line available,  go to next iteration
            else if (stillServing(tellers)) {
                for(int i = 0; i < tellers.length; i++) {
                    tellers[i]--;
                    if(tellers[i] < 0)
                        tellers[i] = 0;
                }
                iteration++;
            }
            else {
                break;
            }
        }

        System.out.println();
        return iteration;
    }

    private static boolean stillServing(int[] tellers) {
        for(int i : tellers)
            if(i > 0)
                return true;

        return false;
    }

    /**
     * Returns the index of a free line (i.e. a line where the customer time is 0) or -1 if no free line is available
     * @param tellers the array of tellers
     * @return the index of a free line, or -1 if none is free
     */
    public static int freeLine(int[] tellers) {
        for(int i = 0; i < tellers.length; i++)
            if(tellers[i] <= 0)
                return i;

        return -1;
    }

    public static void printTellers(int[] tellers) {
        String tellerString = "";
        for(int i : tellers)
            tellerString += i + ",";
        tellerString = tellerString.substring(0, tellerString.length() -1);

        System.out.println("Tellers: " + tellerString);
    }

}

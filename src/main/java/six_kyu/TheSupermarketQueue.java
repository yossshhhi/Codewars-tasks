package six_kyu;

import java.util.Arrays;

// https://www.codewars.com/kata/57b06f90e298a7b53d000a86

public class TheSupermarketQueue {

    public static int solveSuperMarketQueue(int[] customers, int n) {
        if (customers.length == 0) {
            return 0;
        }
        int[] checkoutTills = new int[n];
        for (int i = 0; i < customers.length; i++) {
            Arrays.sort(checkoutTills);
            checkoutTills[0] += customers[i];
        }
        Arrays.sort(checkoutTills);
        return checkoutTills[n - 1];
    }
}

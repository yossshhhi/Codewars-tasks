package five_kyu;

import java.util.ArrayList;
import java.util.List;

// https://www.codewars.com/kata/55aa075506463dac6600010d/java
public class SumSquaredDivisors {
    public static String listSquared(long m, long n) {
        String result = "[";
        List<Long> list = new ArrayList<>();
        for (long j = m; j <= n; j++) {
            for (long i = 1; i <= n; i++) {
                if (j % i == 0) {
                    list.add(i);
                }
            }
            long sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += (long) Math.pow(list.get(i), 2);
            }
            long sqrt = (long) Math.sqrt(sum);
            if ((long) Math.pow(sqrt, 2) == sum) {
                result += "[" + j + ", " + sum + "], ";
            }
            list.clear();
        }
         if (result.length() == 1)
             return "[]";

        return result.substring(0, result.length() - 2) + "]";
    }
}

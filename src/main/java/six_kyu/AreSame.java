package six_kyu;

import java.util.Arrays;

// https://www.codewars.com/kata/550498447451fbbd7600041c

public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null )
            return false;

        if (a.length == 0 && b.length == 0)
            return true;

        boolean out = false;
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * a[i];
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = Math.abs(b[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        if(Arrays.equals(a, b)) {
            out = true;
        }
        return out;
    }
}

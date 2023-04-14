package six_kyu;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.codewars.com/kata/523f5d21c841566fde000009

public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {
        if (b.length == 0) {
            return a;
        }
        ArrayList<Integer> bArr = new ArrayList<>();
        Arrays.sort(b);
        bArr.add(b[0]);
        for (int i = 1; i < b.length; i++) {
            if(b[i] != b[i - 1]) {
                bArr.add(b[i]);
            }
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int k : bArr) {
                if (a[i] == k) {
                    a[i] = bArr.get(0);
                    count++;
                }
            }
        }
        int[] a2 = new int[a.length - count];
        int l = 0;
        for (int a1 : a) {
            if (a1 != bArr.get(0)) {
                a2[l] = a1;
                l++;
            }
        }
        return a2;
    }
}

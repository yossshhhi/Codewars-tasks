package five_kyu;

import java.util.ArrayList;
import java.util.List;

// https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1/java
public class Snail {
    public static int[] snail(int[][] array) {
        if (array[0].length == 0)
            return new int[0];
        List<Integer> list = new ArrayList<>();
        int n = array.length;

        while (true) {
            for (int i = array.length - n; i < n; i++) {
                list.add(array[array.length - n][i]);
            }
            n--;
            if (n == 0)
                break;
            for (int i = array.length - n; i <= n; i++) {
                list.add(array[i][n]);
            }
            for (int i = n - 1; i >= array.length - n - 1; i--) {
                list.add(array[n][i]);
            }
            for (int i = n - 1; i >= array.length - n; i--) {
                list.add(array[i][array.length - n - 1]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

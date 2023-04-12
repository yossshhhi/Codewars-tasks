package six_kyu;

import java.util.Arrays;

// https://www.codewars.com/kata/585d7d5adb20cf33cb000235

public class FindTheUniqueNumber {

    public static double findUniq(double arr[]) {
        Arrays.sort(arr);
        if (arr[0] == arr[1])
            return arr[arr.length - 1];
        return arr[0];
    }
}

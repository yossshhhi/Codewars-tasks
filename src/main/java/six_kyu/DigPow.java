package six_kyu;

// https://www.codewars.com/kata/5552101f47fc5178b1000050

public class DigPow {

    public static long digPow(int n, int p) {
        String nStr = String.valueOf(n);
        String[] arr = nStr.split("");
        int sum = 0;
        for (int i = 0; i < arr.length; i++, p++) {
            sum += Math.pow(Integer.parseInt(arr[i]), p);
        }
        int k = sum / n;
        if (sum == k * n) {
            return k;
        }
        return -1;
    }
}

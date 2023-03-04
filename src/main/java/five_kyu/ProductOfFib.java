package five_kyu;

import java.util.Arrays;

public class ProductOfFib {

    // Your function productFib takes an integer (prod) and returns an array:
    // {F(n), F(n+1), 1} if F(n) * F(n+1) = prod.
    // If you don't find two consecutive F(n) verifying F(n) * F(n+1) = prod you will return
    // {F(n), F(n+1), 0}
    // F(n) being the smallest one such as F(n) * F(n+1) > prod.

    public static long[] productFib(long prod) {
        long fibN1 = 0L;
        long fibN2 = 1L;
        long product = 0L;
        while (product < prod){
            long sum = fibN1 + fibN2;
            fibN1 = fibN2;
            fibN2 = sum;
            product = fibN1 * fibN2;
        }
        return new long[] {fibN1, fibN2, product == prod ? 1 : 0};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productFib(4895))); //{55, 89, 1}
        System.out.println(Arrays.toString(productFib(5895))); //{89, 144, 0}
    }


}

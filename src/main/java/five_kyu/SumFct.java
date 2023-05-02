package five_kyu;

import java.math.BigInteger;

public class SumFct {

    public static BigInteger perimeter(BigInteger n) {
        BigInteger first = BigInteger.ONE;
        BigInteger second = BigInteger.ONE;
        BigInteger fib;
        BigInteger sum = BigInteger.TWO;
        int integerN = n.intValue();
        for (int i = 3; i <= integerN + 1; i++) {
            fib = first.add(second);
            first = second;
            second = fib;
            sum = sum.add(fib);

        }
        return sum.multiply(BigInteger.valueOf(4));
    }
}

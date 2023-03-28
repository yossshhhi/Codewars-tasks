package six_kyu;

// https://www.codewars.com/kata/5592e3bd57b64d00f3000047

public class BuildAPileOfCubes {

    public static long findNb(long m) {
        long mbNb = 0;
        long count = 0;
        for (long i = 1; mbNb < m; ++i) {
            mbNb += i * i * i;
            count = i;
        }
        if (mbNb != m) {
            return -1;
        }
        return count;
    }
}

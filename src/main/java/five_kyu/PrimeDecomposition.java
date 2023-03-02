package five_kyu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeDecomposition {

    // For a positive number n > 1, find the factorization of n into prime factors.
    // The result will be a line like this:
    // "(p1**n1)(p2**n2)...(pk**nk)"
    // with p(i) in ascending order and n(i) empty if n(i) is 1.

    public static String factors(int n) {
        List<Integer> factors = new ArrayList<>();
        int p = 2;
        while (n > 1){
            if (n % p == 0) {
                n = n / p;
                factors.add(p);
            } else {
                p++;
            }
        }
        Map<Integer, Integer> duplicateCountMap = factors.stream().collect(
                        Collectors.toMap(Function.identity(), factor -> 1, Math::addExact));

        Stream<Map.Entry<Integer,Integer>> sorted = duplicateCountMap.entrySet().stream().sorted(Map.Entry.comparingByKey());

        StringBuilder result = new StringBuilder();
        sorted.forEach((entry) -> {
            if (entry.getValue() == 1) {
                result.append("(").append(entry.getKey()).append(")");
            } else {
                result.append("(").append(entry.getKey()).append("**").append(entry.getValue()).append(")");
            }
        });
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(factors(7775460)); // (2**2)(3**3)(5)(7)(11**2)(17)
        System.out.println(factors(86240)); // (2**5)(5)(7**2)(11)
    }
}

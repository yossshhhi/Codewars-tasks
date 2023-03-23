package five_kyu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.codewars.com/kata/5270d0d18625160ada0000e4/java

public class GreedIsGood {
    public static int greedy(int[] dice){
        Map<Integer, Integer> count = new HashMap<>();
        Arrays.stream(dice).forEach(i -> count.put(i, count.getOrDefault(i, 0) + 1));
        count.forEach((key, value) -> {
            if (value < 3 && (key == 1 || key == 5)) {
                if (key == 1) {
                    count.put(key, 100 * value);
                } else {
                    count.put(key, 50 * value);
                }
            } else if (value >= 3) {
                if (key == 1) {
                    count.put(key, 1000 + ((value - 3) * 100));
                } else if (key == 5) {
                    count.put(key, key * 100 + ((value - 3) * 50));
                } else {
                    count.put(key, key * 100);
                }
            } else {
                count.put(key, 0);
            }
        });
        return count.values().stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println(greedy(new int[]{5,1,3,4,1})); // 250
        System.out.println(greedy(new int[]{1,1,1,3,1})); // 1100
        System.out.println(greedy(new int[]{2,4,4,5,4})); // 450
    }
}

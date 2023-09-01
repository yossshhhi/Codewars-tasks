package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int num : nums) {
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : numsMap.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }
}

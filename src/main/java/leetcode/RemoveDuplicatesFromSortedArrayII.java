package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150

public class RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        int[] distinct = Arrays.stream(nums).distinct().toArray();
        int index = 0;
        int temp = distinct[index];
        int count = 0;
        int exclude = 0;
        for (int i = 0; i < nums.length; i++) {
            if (temp == nums[i]) {
                count++;
            } else {
                temp = distinct[++index];
                count = 1;
            }
            if (count > 2) {
                nums[i] = 100_000;
                exclude++;
            }
        }
        Arrays.sort(nums);
        return nums.length - exclude;
    }
}

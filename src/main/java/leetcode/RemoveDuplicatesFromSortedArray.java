package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int[] distinct = Arrays.stream(nums).distinct().toArray();
        System.arraycopy(distinct, 0, nums, 0, distinct.length);
        return distinct.length;
    }
}

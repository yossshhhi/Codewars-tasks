package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = 101;
            } else {
                count++;
            }
        }
        Arrays.sort(nums);
        return count;
    }
}

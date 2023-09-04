package leetcode;

// https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length < k) {
            for (int i = 0; i < k; i++) {
                int last = nums[nums.length - 1];
                System.arraycopy(nums, 0, nums, 1, nums.length - 1);
                nums[0] = last;
            }
        } else {
            int[] right = new int[nums.length - k];
            int[] left = new int[k];
            System.arraycopy(nums, 0, right, 0, right.length);
            System.arraycopy(nums, nums.length - k, left, 0, k);
            System.arraycopy(left, 0, nums, 0, k);
            System.arraycopy(right, 0, nums, k, right.length);
        }
    }
}

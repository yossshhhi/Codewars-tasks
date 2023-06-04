package leetcode;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

public class FindMin {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4, 5, 6, 0, 1, 2, 3}));
    }

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (true) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (nums[low] > nums[high]) {
                if (midVal < nums[high]) {
                    high = mid;
                } else if (midVal > nums[high]) {
                    low = mid + 1;
                } else {
                    return midVal;
                }
            } else {
                if (midVal < nums[low]) {
                    low = mid;
                } else if (midVal > nums[low]) {
                    high = mid - 1;
                } else {
                    return midVal;
                }
            }
        }
    }
}

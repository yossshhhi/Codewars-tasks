package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp = m;
        for (int i = 0; i < n; i++) {
            nums1[temp] = nums2[i];
            temp++;
        }
        Arrays.sort(nums1);
    }
}

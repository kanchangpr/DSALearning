package com.kanchan;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // Handle cases where k >= n
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums1, 3);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int[] nums2 = {-1, -100, 3, 99};
        rotate(nums2, 2);
        for (int num : nums2) {
            System.out.print(num + " ");
        }
    }
}


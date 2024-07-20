package com.kanchan;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int maxReach = 0; // The furthest position we can reach

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // If current index is greater than maxReach, we can't proceed further
            }
            maxReach = Math.max(maxReach, i + nums[i]); // Update the furthest position we can reach
        }
        return true; // If we complete the loop, it means we can reach the last index
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums1)); // Output: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums2)); // Output: false
    }
}


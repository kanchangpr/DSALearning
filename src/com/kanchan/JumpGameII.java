package com.kanchan;

public class JumpGameII {
    public static int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0; // If there's only one element, no jumps are needed

        int jumps = 0; // Number of jumps
        int currentEnd = 0; // The end of the range for the current jump
        int farthest = 0; // The farthest index we can reach

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // Update the farthest index we can reach

            // If we have reached the end of the current jump range
            if (i == currentEnd) {
                jumps++; // Increment the jump count
                currentEnd = farthest; // Update the end of the range for the next jump

                // If the current end reaches or exceeds the last index, we are done
                if (currentEnd >= n - 1) break;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(jump(nums1)); // Output: 2

        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(jump(nums2)); // Output: 2
    }
}


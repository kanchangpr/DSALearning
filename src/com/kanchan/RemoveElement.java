package com.kanchan;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int k = 0; // Pointer for the position of the next non-val element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int k = removeElement(nums, val);
        
        // Print the modified array and k
        System.out.println("k = " + k);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        // Expected output: k = 2, nums = [2, 2]
    }
}

package com.kanchan;

public class RemoveDuplicates {
	public static int removeDuplicates(int[] nums) {
        int k=1;
        for (int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,3,3,4};
        int k = removeDuplicates(nums);
        
        // Print the modified array and k
        System.out.println("k = " + k);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        // Expected output: k = 2, nums = [2, 2]
    }
}

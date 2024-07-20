package com.kanchan;

import java.util.Arrays;

public class TwoSum2 {
	// Main method to test the function
    public static void main(String[] args) {
    	TwoSum2 solution = new TwoSum2();
        
        // Example inputs
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        
        int[] numbers2 = {2, 3, 4, 3};
        int target2 = 6;
        
        int[] numbers3 = {-1, 0};
        int target3 = -1;
        
        // Output results
        System.out.println("Result: " + Arrays.toString(solution.twoSum(numbers1, target1))); // Expected: [1, 2]
        System.out.println("Result: " + Arrays.toString(solution.twoSum(numbers2, target2))); // Expected: [1, 3]
        System.out.println("Result: " + Arrays.toString(solution.twoSum(numbers3, target3))); // Expected: [1, 2]
    }
    
    // Function to find two numbers that add up to the target
    public int[] twoSum(int[] numbers, int target) {
        // Initialization of variables (pointers, etc.)
        int i = 0;
        int j = numbers.length-1;
        // Loop to iterate through the array with the two-pointer technique
        while(i < j) {
        	int sum = numbers[i] + numbers[j];
        	if (sum == target) {
        		return new int[] {i+1 ,j+1};
        	}else if (sum > target) {
				j--;
			}else {
				i++;
			}
        }
        // Return the result
        return new int[] {}; // Placeholder return statement
    }
}

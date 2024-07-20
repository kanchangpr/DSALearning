package com.kanchan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	// Main method to test the function
    public static void main(String[] args) {
    	TwoSum solution = new TwoSum();
        
        // Example inputs
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        
        int[] numbers2 = {3,2,4};
        int target2 = 6;
        
        int[] numbers3 = {-1, 0};
        int target3 = -1;
        
        // Output results
        System.out.println("Result: " + Arrays.toString(solution.twoSum(numbers1, target1))); // Expected: [1, 2]
        System.out.println("Result: " + Arrays.toString(solution.twoSum(numbers2, target2))); // Expected: [1, 3]
        System.out.println("Result: " + Arrays.toString(solution.twoSum(numbers3, target3))); // Expected: [1, 2]
    }
    
    // Function to find two numbers that add up to the target
    public int[] twoSum(int[] nums, int target) {
    	// Map to store number and its index
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                // Return indices if found
                return new int[] { map.get(complement), i };
            }
            
            // Store current number and its index in the map
            map.put(nums[i], i);
        }
        
        // If no solution is found, return an empty array or handle edge case as needed
        return new int[0];
    }
}

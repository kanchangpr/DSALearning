package com.kanchan;

public class MaxProfit2 {
	public int maxProfit(int[] prices) { 
		int maxProfit = 0;
        // Initialize variables to track the minimum price and maximum profit
		// Iterate through the prices array
        for (int i = 1; i < prices.length; i++) {
            // If the next day's price is higher than the current day's price
            if (prices[i] > prices[i - 1]) {
                // Add the difference to the maxProfit
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        // Return the maximum profit
        return maxProfit;
    }

    public static void main(String[] args) {
    	MaxProfit2 solution = new MaxProfit2();
        
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + solution.maxProfit(prices1)); // Expected: 5
        
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit: " + solution.maxProfit(prices2)); // Expected: 0
    }
}

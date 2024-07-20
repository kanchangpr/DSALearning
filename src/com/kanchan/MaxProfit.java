package com.kanchan;

public class MaxProfit {
	public int maxProfit(int[] prices) {
        // Initialize variables to track the minimum price and maximum profit
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        // Iterate through the prices array
        for (int i = 0; i < prices.length-1; i++) {
         if(prices[i]<minPrice) {
        	 minPrice=prices[i];
         }
         int profit=prices[i+1]-minPrice;
         if(profit>maxProfit) {
        	 maxProfit=profit;
         }
        }
        
        // Return the maximum profit
        return maxProfit;
    }

    public static void main(String[] args) {
    	MaxProfit solution = new MaxProfit();
        
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + solution.maxProfit(prices1)); // Expected: 5
        
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit: " + solution.maxProfit(prices2)); // Expected: 0
    }
}

package com.kanchan;

import java.util.HashMap;

public class RomanToInt {
	public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
        	int currentVal = romanMap.get(s.charAt(i));
        	if(i<n-1 && currentVal<romanMap.get(s.charAt(i+1))) {
        		total = total - currentVal + romanMap.get(s.charAt(i+1));
        		i++;
        	}else {
        		total += currentVal;
        	}
        }

        return total;
    }
	
	public static void main(String[] args) {
		RomanToInt solution = new RomanToInt();
        
        System.out.println("III -> " + solution.romanToInt("III")); // Expected: 3
        System.out.println("IV -> " + solution.romanToInt("IV")); // Expected: 4
        System.out.println("IX -> " + solution.romanToInt("IX")); // Expected: 9
        System.out.println("LVIII -> " + solution.romanToInt("LVIII")); // Expected: 58
        System.out.println("MCMXCIV -> " + solution.romanToInt("MCMXCIV")); // Expected: 1994
    }
}

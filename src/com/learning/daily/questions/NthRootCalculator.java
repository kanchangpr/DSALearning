package com.learning.daily.questions;

public class NthRootCalculator {

	public static double root(double x, int n) {
		if (x == 0) {
			return 0;
		}

		double low = 0;
		double high = Math.max(1, x);
		double errorMargin = 0.001;
		double mid = 0.0;
		while (high - low > errorMargin) {
			mid = (low + high) / 2.0;
			double midPowerN = Math.pow(mid, n);

			if (Math.abs(midPowerN - x) < errorMargin) {
				return mid;
			} else if (midPowerN < x) {
				low = mid;
			} else {
				high = mid;
			}
		}

		return mid;
	}

	public static void main(String[] args) {
		// Test cases
		System.out.printf("root(7, 3) = %.3f%n", root(7, 3)); // Expected output: close to 1.913
		System.out.printf("root(9, 2) = %.3f%n", root(9, 2)); // Expected output: close to 3.000
	}
}

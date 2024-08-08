package com.learning.google;

import java.util.HashSet;

/**
 * Solution for Unique Email Addresses problem.
 * 
 * Given an array of email addresses, this program returns the number of unique
 * email addresses that actually receive emails considering the rules for local
 * names with '.' and '+' characters.
 * 
 * Time Complexity: O(n * m) Space Complexity: O(n) Where n is the number of
 * emails and m is the average length of each email.
 */
public class UniqueEmailAddresses {
	public int numUniqueEmails(String[] emails) {
		HashSet<String> uniqueEmails = new HashSet<>();

		for (String email : emails) {
			String[] parts = email.split("@");
			String local = parts[0];
			String domain = parts[1];

			if (local.contains("+")) {
				local = local.substring(0, local.indexOf('+'));
			}

			local = local.replace(".", "");
			uniqueEmails.add(local + "@" + domain);
		}

		return uniqueEmails.size();
	}

	public static void main(String[] args) {
		UniqueEmailAddresses solution = new UniqueEmailAddresses();
		String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com" };
		System.out.println(solution.numUniqueEmails(emails)); // Output: 2
	}
}

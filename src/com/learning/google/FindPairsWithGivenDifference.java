package com.learning.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FindPairsWithGivenDifference {

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        List<int[]> result = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();

        for (int num : arr) {
            numSet.add(num);
        }

        for (int y : arr) {
            int x = y + k;
            if (numSet.contains(x)) {
                result.add(new int[]{x, y});
            }
        }

        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        int[] arr = {0, -1, -2, 2, 1};
        int k = 1;
        int[][] res = findPairsWithGivenDifference(arr, k);

        for (int[] pair : res) {
            System.out.println(pair[0] + ", " + pair[1]);
        }
    }
}

package com.roczniak.codility;

// you can also use imports, for example:

import java.util.HashSet;
import java.util.Set;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class FindANumber {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> numbers = new HashSet<>();
        for (int i : A) {
            numbers.add(i);
        }
        int missingNumber = 1;
        if (!numbers.isEmpty()) {
            for (int i = 1; i < numbers.size() + 2; i++) {
                if (!numbers.contains(i)) {
                    missingNumber = i;
                    break;
                }
            }
        }
        return missingNumber;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2};
        System.out.println(solution(A));
    }
}

package com.roczniak.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAMinNumber {
    public int solution(int[] A) {
        // write your code in Java SE 8

        List<Integer> numbers = new ArrayList<>();
        for (int i : A) {
            numbers.add(i);
        }
        Collections.sort(numbers);
        int min = 1;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == min) {
                min++;
            } else if (numbers.get(i) > min) {
                return min;
            }
        }
        return min;
    }
}
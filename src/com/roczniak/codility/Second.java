package com.roczniak.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Second {
    public static void main(String[] mvc) {
        Second second = new Second();
        int[] a = {1, 4, 2};
        System.out.println(second.solution(a));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 1) {
            return -2;
        }

        List<Integer> list = new ArrayList<>();
        for (int a : A) {
            list.add(a);
        }

        Collections.sort(list);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            int tempMin = list.get(i + 1) - list.get(i);
            if (tempMin < min) {
                min = tempMin;
            }
        }

        return (min > 100000000) ? -1 : min;
    }
}

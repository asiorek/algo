package com.roczniak.codility;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        int[] A = {9, 5, 7, 3, 2, 7, 3, 1, 10, 8};

        int result = permutation.solution(A);

        System.out.println(result);
    }

    public int solution(int[] A) {
        // write your code in Java SE 8

        List<Integer> list = new ArrayList<>();
        for (int a : A) {
            list.add(a);
        }

        Collections.sort(list);

        Set<Integer> set = new HashSet<>(list);

        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (Integer s : set) {
            map.put(i++, s);
        }

        if (map.get(map.size() - 1) == map.size() && map.size() == A.length) {
            return 1;
        } else {
            return 0;
        }
    }
}
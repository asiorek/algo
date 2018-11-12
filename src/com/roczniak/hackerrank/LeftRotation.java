package com.roczniak.hackerrank;

import java.util.*;

public class LeftRotation {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        scanner.close();

        System.out.println("Stop scanning");

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = a[(d + i) % n];
            System.out.print(String.valueOf(result[i]) + " ");
        }
    }

    static void customSort(int[] arr) {
        Map<Integer, Integer> occurences = new LinkedHashMap<>();
        for (int anArr : arr) {
            if (occurences.containsKey(anArr)) {
                occurences.put(anArr, occurences.get(anArr) + 1);
            } else {
                occurences.put(anArr, 1);
            }
        }

        Map<Integer, Integer> sortedByValue = new TreeMap<>(occurences);

        Map<Integer, Integer> sortedByOccurences = sortingByValue(sortedByValue);


        for (Map.Entry<Integer, Integer> entry : sortedByOccurences.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.println(entry.getKey());
            }
        }
    }

    static Map<Integer, Integer> sortingByValue(Map<Integer, Integer> unsortedMap) {

        List<Map.Entry<Integer, Integer>> listOfMap =
                new LinkedList<>(unsortedMap.entrySet());

        Collections.sort(listOfMap, (v1, v2) -> (v1.getValue()).compareTo(v2.getValue()));

        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : listOfMap) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    static void closestNumbers(List<Integer> numbers) {
        Collections.sort(numbers);

        List<Pair> pairs = new LinkedList<>();

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < numbers.size(); i++) {
            int tempDiff = Math.abs(numbers.get(i - 1) - numbers.get(i));
            if (tempDiff < minDiff) {
                pairs.clear();
                minDiff = tempDiff;
            } else if (tempDiff == minDiff) {
                pairs.add(new Pair(numbers.get(i - 1), numbers.get(i)));
            }
        }

        Collections.sort(pairs, (v1, v2) -> (v1.first).compareTo(v2.second));

        for (Pair pair : pairs) {
            System.out.println(pair.first + " " + pair.second);
        }
    }

    /*
     * Complete the 'findSimilar' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */
    public static long findSimilar(String a, String b) {
        // Write your code here


        return 10L;
    }

    public static boolean isSimilar(String a, String b) {
        List<Character> listA = new LinkedList<>();
        List<Character> listB = new LinkedList<>();
        for (char c : a.toCharArray()) {
            listA.add(c);
        }
        for (char c : b.toCharArray()) {
            listB.add(c);
        }

        Collections.sort(listA);
        Collections.sort(listB);

        if (listA.equals(listB)) {
            return true;
        } else {
            return false;
        }
    }

    static class Pair {
        public Integer first;
        public Integer second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


}


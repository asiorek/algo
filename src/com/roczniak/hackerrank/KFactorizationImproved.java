package com.roczniak.hackerrank;

import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class KFactorizationImproved {

    private static final Scanner scanner = new Scanner(System.in);
    static Set<Set<Integer>> usedCombinations = new HashSet<>();

    // Complete the kFactorization function below.
    static long[] kFactorization(int n, int[] A) {
        List<Long> result = new ArrayList<>();
        result.add(1l);
        List<Integer> inputA = new ArrayList<>();
        for (int i = 0; i < A.length; ++i) {
            inputA.add(A[i]);
        }
        List<Long> ultimateResult = function(n, inputA, result, new ArrayList<>());
        long[] results = new long[ultimateResult.size()];
        for (int i = 0; i < ultimateResult.size(); ++i) {
            results[i] = ultimateResult.get(i);
        }
        long[] empty = {-1};
        return results.length > 0 ? results : empty;
    }

    static List<Long> function(long n, List<Integer> A, List<Long> currentList, List<Integer> usedFactors) {

        long current = currentList.get(currentList.size() - 1);
        if (current > n) {
            return new ArrayList<>();
        } else if (current == n) {
            return currentList;
        }


        List<List<Long>> results = A.stream()
                .sorted()
                .map(factor -> {
                    if (!usedFactors.isEmpty() && factor < usedFactors.get(usedFactors.size() - 1)) {
                        return new ArrayList<Long>();
                    }

                    List<Integer> newFactors = new ArrayList<>();
                    newFactors.addAll(usedFactors);
                    newFactors.add(factor);

                    long newLastStep = factor * current;
                    List<Long> newSteps = new ArrayList<>();
                    newSteps.addAll(currentList);
                    newSteps.add(newLastStep);

                    return function(n, A, newSteps, newFactors);
                })
                .collect(toList());
        return getCorrectAwesome(results);
        //return getCorrect(getShortest(results), currentList.size());
    }

    static List<Long> getCorrectAwesome(List<List<Long>> lists) {
        List<Long> resultPointer = new ArrayList<>();
        long min = Long.MAX_VALUE;
        for (List<Long> list : lists) {
            if (!list.isEmpty() && list.size() < min) {
                resultPointer = list;
                min = list.size();
            }
        }
        return resultPointer;
    }

    static List<List<Integer>> getShortest(List<List<Integer>> lists) {
        List<List<Integer>> results = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (List<Integer> list : lists) {
            if (!list.isEmpty() && list.size() < min) {
                min = list.size();
                results.clear();
                results.add(list);
            } else if (!list.isEmpty() && list.size() == min) {
                results.add(list);
            }
        }
        return results;
    }

    static List<Integer> getCorrect(List<List<Integer>> lists, int index) {
        int min = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            if (list.get(index) < min) {
                min = list.get(index);
                result = list;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] A = new int[k];

        String[] AItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < k; i++) {
            int AItem = Integer.parseInt(AItems[i]);
            A[i] = AItem;
        }

        long[] result = kFactorization(n, A);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        scanner.close();
    }

}

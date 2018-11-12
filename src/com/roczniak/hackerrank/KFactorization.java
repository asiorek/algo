package com.roczniak.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class KFactorization {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the kFactorization function below.
    static int[] kFactorization(int n, int[] A) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        List<Integer> inputA = new ArrayList<>();
        for (int i = 0; i < A.length; ++i) {
            inputA.add(A[i]);
        }
        List<Integer> ultimateResult = function(n, inputA, result);
        int[] results = new int[ultimateResult.size()];
        for (int i = 0; i < ultimateResult.size(); ++i) {
            results[i] = ultimateResult.get(i);
        }
        int[] empty = {-1};
        return results.length > 0 ? results : empty;
    }

    static List<Integer> function(int n, List<Integer> A, List<Integer> currentList) {
        int current = currentList.get(currentList.size() - 1);
        if (current > n) {
            return new ArrayList<>();
        } else if (current == n) {
            return currentList;
        }
        List<List<Integer>> results = A.stream()
                .map(factor -> factor * current)
                .map(lastElement -> {
                    List<Integer> newList = new ArrayList<>();
                    newList.addAll(currentList);
                    newList.add(lastElement);
                    return newList;
                })
                .map(newList -> function(n, A, newList))
                .collect(toList());

        return getCorrect(getShortest(results), currentList.size());
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

        int[] result = kFactorization(n, A);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
        scanner.close();
    }
}

package com.roczniak.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArithmeticExpressionImproved {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the arithmeticExpressions function below.
    private static String arithmeticExpressions(int[] arr) {
        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i : arr) {
            listOfNumbers.add(i);
        }
        String finalResult = String.valueOf(listOfNumbers.get(0));
        return function(listOfNumbers.subList(1, listOfNumbers.size()),
                listOfNumbers.get(0), finalResult);

    }

    private static String function(List<Integer> listOfNumbers, int result, String resultString) {
        if (listOfNumbers.isEmpty() && result % 101 == 0) {
            return resultString;
        } else if (listOfNumbers.isEmpty()) {
            return "";
        } else {
            List<Integer> newList = listOfNumbers.subList(1, listOfNumbers.size());
            int firstNumber = listOfNumbers.get(0);
            String result1 = function(newList,
                    result + firstNumber, resultString + "+" + String.valueOf(firstNumber));
            if (result1 != "") {
                return result1;
            }
            String result2 = function(newList,
                    result - firstNumber, resultString + "-" + String.valueOf(firstNumber));
            if (result2 != "") {
                return result2;
            }
            return function(newList,
                    result * firstNumber, resultString + "*" + String.valueOf(firstNumber));
        }
    }

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        String result = arithmeticExpressions(arr);

        System.out.println(result);

        scanner.close();
    }
}

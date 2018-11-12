package com.roczniak.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArithmeticExpression {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the arithmeticExpressions function below.

    private static String finalResult = "";

    private static String arithmeticExpressions(long[] arr) {
        List<Long> listOfNumbers = new ArrayList<>();
        for (long i : arr) {
            listOfNumbers.add(i);
        }

        finalResult = String.valueOf(listOfNumbers.get(0));
        function(listOfNumbers,
                listOfNumbers.get(0), finalResult, 0);
        return finalResult;
    }

    private static boolean function(List<Long> listOfNumbers, long result, String resultString, int currentIdx) {
        if (currentIdx >= listOfNumbers.size() - 1 && result % 101 == 0) {
            finalResult = resultString;
            return true;
        } else if (currentIdx >= listOfNumbers.size() - 1) {
            return false;
        } else {
            long firstNumber = listOfNumbers.get(currentIdx);
            return function(listOfNumbers,
                    result + firstNumber, resultString + "+" + String.valueOf(firstNumber), currentIdx + 1)
                    || function(listOfNumbers,
                    result - firstNumber, resultString + "-" + String.valueOf(firstNumber), currentIdx + 1)
                    || function(listOfNumbers,
                    result * firstNumber, resultString + "*" + String.valueOf(firstNumber), currentIdx + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        String result = arithmeticExpressions(arr);

        System.out.println(result);

        scanner.close();
    }
}

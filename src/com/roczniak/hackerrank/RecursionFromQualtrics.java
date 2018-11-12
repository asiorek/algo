package com.roczniak.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class RecursionFromQualtrics {

    private static char[] operators = new char[]{'+', '-', '*'};
    private static int resultToFind;

    private static void function(String string, int score) {
        resultToFind = score;
        String[] arrayOfStrings = string.split(" ");

        List<Integer> listOfIntegers = new ArrayList<>();
        for (String s : arrayOfStrings) {
            listOfIntegers.add(Integer.valueOf(s));
        }

        evaluate(listOfIntegers.subList(1, listOfIntegers.size()),
                String.valueOf(string.charAt(0)), listOfIntegers.get(0));
    }

    private static String evaluate(List<Integer> integers, String resultString, int result) {
        if (integers.isEmpty() && result == resultToFind) {
            System.out.println(resultString);
            return resultString;
        } else if (integers.isEmpty()) {
            return "";
        } else {
            return evaluate(integers.subList(1, integers.size()), resultString + operators[0] + String.valueOf(integers.get(0)),
                    result + integers.get(0))
                    + evaluate(integers.subList(1, integers.size()), resultString + operators[1] + String.valueOf(integers.get(0)),
                    result - integers.get(0))
                    + evaluate(integers.subList(1, integers.size()), resultString + operators[2] + String.valueOf(integers.get(0)),
                    result * integers.get(0));
        }
    }

    public static void main(String[] args) {
        function("1 0 5", 5);
        function("2 1 5", 5);
    }
}

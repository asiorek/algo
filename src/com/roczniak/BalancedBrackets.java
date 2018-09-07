package com.roczniak;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        boolean isBalanced = false;
        Stack<Character> brackets = new Stack<>();

        for (Character letter : s.toCharArray()) {
            switch (letter) {
                case '{':
                case '(':
                case '[':
                    brackets.push(letter);
                    break;
                case '}':
                    if (brackets.peek().equals('{')) {
                        brackets.pop();
                        isBalanced = true;
                        break;
                    } else {
                        isBalanced = false;
                        return "NO";
                    }
                case ')':
                    if (brackets.peek().equals('(')) {
                        brackets.pop();
                        isBalanced = true;
                        break;
                    } else {
                        isBalanced = false;
                        return "NO";
                    }
                case ']':
                    if (brackets.peek().equals('[')) {
                        brackets.pop();
                        isBalanced = true;
                        break;
                    } else {
                        isBalanced = false;
                        return "NO";
                    }
                default:
                    isBalanced = true;
                    break;
            }
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }

        scanner.close();
    }
}

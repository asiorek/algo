package com.roczniak;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the extraLongFactorials function below.
            static void extraLongFactorials(int n) {
            BigInteger result = BigInteger.valueOf(1);
            for(int i = 1; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            System.out.println(result.toString());
        }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}

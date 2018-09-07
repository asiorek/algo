package com.roczniak;

import java.io.IOException;
import java.util.Scanner;

public class ReverseArray {

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {
        int length = a.length;
        int[] reversed = new int[length];
        for(int i = 0; i < length; i++){
            reversed[length-1-i] = a[i];
        }
        return reversed;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] res = reverseArray(arr);

        for (int i = 0; i < res.length; i++) {
            System.out.print(String.valueOf(res[i]));

            if (i != res.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.print("\n");
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}

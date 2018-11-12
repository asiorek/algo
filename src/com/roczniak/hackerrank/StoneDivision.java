package com.roczniak.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoneDivision {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the stoneDivision function below.
    static long stoneDivision(long n, long[] s) {
        return function(s, n, 1);
    }

    static long function(long[] s, long pileSize, long numberOfPiles) {
        List<Long> results = divisable(s, pileSize);
        if (results.isEmpty()) {
            return 0;
        }
        return numberOfPiles + results.stream()
                .map(r -> function(s, r, (pileSize / r) * numberOfPiles))
                .mapToLong(Long::longValue)
                .max()
                .getAsLong();
    }

    static List<Long> divisable(long[] s, long pileSize) {
        List<Long> result = new ArrayList<>();
        for (long l : s) {
            if (pileSize % l == 0 && l != pileSize) {
                result.add(l);
            }
        }
        return result;

    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            long n = Long.parseLong(nm[0]);

            int m = Integer.parseInt(nm[1]);

            long[] s = new long[m];

            String[] sItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m; i++) {
                long sItem = Long.parseLong(sItems[i]);
                s[i] = sItem;
            }

            long result = stoneDivision(n, s);

            System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}

package com.roczniak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
//        List<Integer> result = new ArrayList<Integer>();
//        result.add(0,0);
//        result.add(1,0);
        int[] result = {0,0};
        for(int i = 0; i < a.size(); i++){
            if(a.get(i) > b.get(i)){
                result[0] += 1;
//                result.add(0, result.get(0)+1);
            }else if(b.get(i) > a.get(i)){
//                result.add(1, result.get(1)+1);
                result[1] += 1;
            }
        }
//        return result.subList(0,2);
         return Arrays.asList(result[0], result[1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a.add(aItem);
        }

        String[] bItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b.add(bItem);
        }

        List<Integer> result = compareTriplets(a, b);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.print("\n");
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}


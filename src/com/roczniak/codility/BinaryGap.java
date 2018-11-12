package com.roczniak.codility;

public class BinaryGap {

    public static int solution(int N) {
        // write your code in Java SE 8
        String regex = ".*10+1.*";
        String binaryString = Integer.toBinaryString(N);
        int maxBinaryGap = 0;
        while (binaryString.matches(regex)) {
            System.out.println(binaryString);
            String tempBinaryString = binaryString.replaceFirst(regex, "ala");
            int tempBinaryGap = binaryString.length() - tempBinaryString.length() - 1;
            if (maxBinaryGap < tempBinaryGap) {
                maxBinaryGap = tempBinaryGap;
            }
            binaryString = tempBinaryString;
            System.out.println(binaryString);
        }
        ;

        return maxBinaryGap;
    }

    public static int solution2(int N) {
        // write your code in Java SE 8
        int maxBinaryGap = 0;
        boolean isGap = false;
        int tempCount = 0;
        char[] array = Integer.toBinaryString(N).toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (!isGap && c == '1') {
                isGap = true;
            } else if (isGap && c == '0') {
                tempCount++;
            } else if (isGap && c == '1') {
                if (tempCount > maxBinaryGap) {
                    maxBinaryGap = tempCount;
                }
                tempCount = 0;
                isGap = false;
                --i;
            }
        }
        return maxBinaryGap;
    }

    public static void main(String[] args) {
        int N = 529;
        String binaryString = Integer.toBinaryString(N);
//        System.out.println(binaryString.matches(".*10++1.*"));
        System.out.println(solution2(N));

    }

}

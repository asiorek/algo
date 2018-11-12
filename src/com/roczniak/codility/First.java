package com.roczniak.codility;

public class First {

    public static void main(String[] args) {
        First first = new First();
        int[] a = {1, 2, 5, 7, 9};
        System.out.println(first.solution(a, 9));
    }

    int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else if (A[m] < X) {
                l = m + 1;
            } else {
                l = m;
                break;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
}

package com.roczniak.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private final Map<Integer, Integer> integers = new HashMap<Integer, Integer>() {{
        put(1, 1);
        put(2, 1);
    }};


    Main a = new Main() {
        private final String dupa = "Dupa";
    };


    public static void main(String[] args) {
        Integer a = 100001;
        Integer b = 100001;

        System.out.println(a.equals(b));
        System.out.println(a == b);

        Integer c = 1;
        Integer d = 1;

        System.out.println(c.equals(d));
        System.out.println(c == d);

        String s = "asd";

        String.valueOf(s.charAt(2));


        final String a1 = "a";
        System.out.println(a1 == "a");
        System.out.println(new Integer(100000) == new Integer(100000));

        System.out.println("Asla");
    }
}

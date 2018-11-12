package com.roczniak.calculator;

public class Calculator {

    Calculator() {
    }


    public double calculate(Node root) {
        if (root != null) {
            return root.operate();
        } else {
            return 0;
        }
    }
}





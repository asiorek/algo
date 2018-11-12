package com.roczniak.calculator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Beekeper");

        Node root = new Division();
        Node subtracting = new Subtracting();
        root.setLeft(subtracting);
        root.setRight(new Value(2));
        subtracting.setLeft(new Value(10));
        subtracting.setRight(new Value(5));

        Calculator calculator = new Calculator();

        double result = calculator.calculate(root);

        System.out.println(result);
    }
}

//        divide
//      /         \
//    -               2
//   /    \
//10      5
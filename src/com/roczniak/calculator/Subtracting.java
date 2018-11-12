package com.roczniak.calculator;

public class Subtracting extends Node {

    @Override
    public double operate() {
        return getLeft().operate() - getRight().operate();
    }
}

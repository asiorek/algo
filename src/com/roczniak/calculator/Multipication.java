package com.roczniak.calculator;

public class Multipication extends Node {
    @Override
    public double operate() {
        return getLeft().operate() * getRight().operate();
    }
}

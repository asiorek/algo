package com.roczniak.calculator;

public class Value extends Node {

    private double value;

    public Value(double value) {
        this.value = value;
    }

    @Override
    public double operate() {
        return value;
    }
}

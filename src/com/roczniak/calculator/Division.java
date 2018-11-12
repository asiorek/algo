package com.roczniak.calculator;

public class Division extends Node {

    public Division() {
    }

    @Override
    public double operate() {
        return getLeft().operate() / getRight().operate();
    }
}

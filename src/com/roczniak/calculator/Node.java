package com.roczniak.calculator;

public abstract class Node {

    private Node left;
    private Node right;

    Node() {
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public abstract double operate();
}

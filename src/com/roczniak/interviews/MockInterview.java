package com.roczniak.interviews;

import java.util.Stack;

public class MockInterview {

    public static void main(String[] args) {
        Node E = new Node('E', null, null);
        Node D = new Node('D', null, E);
        Node C = new Node('C', null, null);
        Node B = new Node('B', D, null);
        Node root = new Node('A', B, C);

        System.out.println(root.toString());

    }

    private static StringBuilder preorder(Node root, StringBuilder result) {
        if (root == null) {
            result.append("()");
        } else {
            result.append(root.value);
            preorder(root.left, result.append("("));
            result.append(")");
            preorder(root.right, result.append("["));
            result.append("]");
        }

        return result;
    }

    public static Node fromString(String pattern) {
        StringBuilder stringBuilder = new StringBuilder(pattern);
        if (pattern.isEmpty()) {
            return null;
        }
        Node root = new Node(pattern.charAt(0));
        Stack<Character> stack = new Stack<>();
        for (char c : pattern.toCharArray()) {
            if (c == '(') {
//TODO:
            }
        }

        return root;
    }


    public static class Node {
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(char value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public String toString() {
            return preorder(this, new StringBuilder("")).toString();
        }
    }
}

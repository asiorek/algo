package com.roczniak.codility;

import java.util.Stack;

public class Third {
    public static void main(String[] args) {
        Third third = new Third();
        System.out.println(4 == third.solution("RLLLRRRLLR"));
        System.out.println(4 == third.solution("RLRRLLRLRRLL"));
        System.out.println(1 == third.solution("LLRLRLRLRLRLRLRLR"));
        System.out.println(1 == third.solution("LLRLRLRLRLRLRLRLR"));
    }

    public int solution(String S) {
        // write your code in Java SE 8
        Stack<Character> stack = new Stack<>();

        int result = 0;
        for (char c : S.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                result++;
            } else {
                switch (c) {
                    case 'R': {
                        if (stack.peek() == 'L') {
                            stack.pop();
                        } else if (stack.peek() == 'R') {
                            stack.push('R');
                        }
                        break;
                    }
                    case 'L': {
                        if (stack.peek() == 'R') {
                            stack.pop();
                        } else if (stack.peek() == 'L') {
                            stack.push('L');
                        }
                        break;
                    }
                }
            }
        }
        return result;
    }
}

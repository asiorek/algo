package com.roczniak.hackerrank;

import java.util.*;

public class PasswordCracker {

    private static String passwordCracker(String[] pass, String attempt) {
        // Complete this function
        List<String> listOfPass = Arrays.asList(pass);

        List<String> usedPasswords = getAllPasswords(listOfPass, attempt, new LinkedList<>());

        if (usedPasswords.isEmpty()) {
            return "WRONG PASSWORD";
        } else {
            return String.join(" ", usedPasswords);
        }
    }

    private static List<String> getAllPasswords(List<String> listOfPass, String attempt, List<String> usedPasswords) {
        if (attempt.isEmpty()) {
            return usedPasswords;
        } else {
            for (String pass : listOfPass) {
                if (attempt.startsWith(pass)) {
                    usedPasswords.add(pass);
                    return getAllPasswords(listOfPass, attempt.substring(pass.length()), usedPasswords);
                }
            }
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            String[] pass = new String[n];
            for (int pass_i = 0; pass_i < n; pass_i++) {
                pass[pass_i] = in.next();
            }
            String attempt = in.next();
            String result = passwordCracker(pass, attempt);
            System.out.println(result);
        }
        in.close();
    }
}

package com.roczniak.hackerrank;

import java.io.IOException;
import java.util.*;

public class BowlingPins {

    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the isWinning function below.
     */
    static String isWinning(int n, String config) {
        /*
         * Return WIN or LOSE depending on whether you will win
         */
        if (iAmAWinner(n, config, 0)) {
            return "WIN";
        } else {
            return "LOSE";
        }
    }

    private static boolean iAmAWinner(int numberOfPins, String config, int turn) {
        if (!config.contains("I") && turn == 0) {
            return false;
        } else if (!config.contains("I") && turn == 1) {
            return true;
        }
        List<String> pinsList = Arrays.asList(config.split(""));
        List<String> allPossibleConfigs = getAllPossibleConfigs(pinsList, new LinkedList<>());
        for (String conf : allPossibleConfigs) {
            if (iAmAWinner(numberOfPins, conf, ++turn % 2)) {
                return true;
            }
        }
        return false;

    }

    private static List<String> getAllPossibleConfigs(List<String> config, List<String> generatedConfigs) {
        if (!config.contains("I")) {
            return generatedConfigs;
        } else {
            for (int i = 0; i < config.size(); i++) {
                if (config.get(i).equals("I")) {
                    List<String> newConfig = new ArrayList<>(config);
                    newConfig.add(i, "X");
                    generatedConfigs.add(newConfig.toString());
                    if (i + 1 < config.size() && config.get(i + 1).equals("I")) {
                        List<String> newConfig2 = new ArrayList<>(config);
                        newConfig2.add(i, "X");
                        newConfig2.add(i + 1, "X");
                        generatedConfigs.add(newConfig2.toString());
                    }
                }
            }
        }
        return getAllPossibleConfigs(config, generatedConfigs);
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            String config = scanner.nextLine();

            String result = isWinning(n, config);

            System.out.println(result);
        }
    }
}


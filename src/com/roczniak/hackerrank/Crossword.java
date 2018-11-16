package com.roczniak.hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossword {

    private static final Scanner scanner = new Scanner(System.in);

    private static List<String> wordsToFill;
    private static Character[][] grid;
    private static boolean f;

    // Complete the crosswordPuzzle function below.
    private static String[] crosswordPuzzle(String[] crossword, String words) {
        wordsToFill = Arrays.asList(words.split(";"));

        grid = new Character[crossword.length][crossword[0].length()];
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length(); j++) {
                grid[i][j] = crossword[i].charAt(j);
            }
        }

        check(0);

        String[] result = new String[crossword.length];
        for (int i = 0; i < grid.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                stringBuilder.append(grid[i][j]);
            }
            result[i] = stringBuilder.toString();
        }
        return result;
    }

    private static void check(int wordIndex) {

        if (!f) {
            return;
        }
        if (wordIndex == wordsToFill.size()) {
            if (f) {
                f = false;
            }
            return;
        }
        int i, j, p, q, k;
        for (i = 0; i < 10; ++i) {
            for (j = 0; j < 10; ++j) {
                p = i;
                q = j;
                //check vertically
                //find an index where to start recursively putting a word
                for (k = 0; k < wordsToFill.get(wordIndex).length() && p + k < 10; k++) {
                    if (grid[p + k][q] != '-' && grid[p + k][q] != wordsToFill.get(wordIndex).charAt(k)) {
                        break;
                    }
                }

                //fill grid recursively
                if (k == wordsToFill.get(wordIndex).length()) {
                    Character[][] temp = grid;
                    for (k = 0; k < wordsToFill.get(wordIndex).length(); k++) {
                        grid[p + k][q] = wordsToFill.get(wordIndex).charAt(k);
                    }
                    check(wordIndex + 1);
                    grid = temp;
                }

                //check horizontally
                //find an index where to start recursively putting a word
                for (k = 0; k < wordsToFill.get(wordIndex).length() && q + k < 10; k++) {
                    if (grid[p][q + k] != '-' && grid[p][q + k] != wordsToFill.get(wordIndex).charAt(k)) {
                        break;
                    }
                }

                //fill grid recursively
                if (k == wordsToFill.get(wordIndex).length()) {
                    Character[][] temp = grid;
                    for (k = 0; k < wordsToFill.get(wordIndex).length(); k++) {
                        grid[p][q + k] = wordsToFill.get(wordIndex).charAt(k);
                    }
                    check(wordIndex + 1);
                    grid = temp;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        String[] crossword = new String[10];

        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }

        String words = scanner.nextLine();

        String[] result = crosswordPuzzle(crossword, words);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print("\n");
            }
        }

        scanner.close();
    }

    //SAMPLE INPUT:
   /*
   +-++++++++
    +-++++++++
    +-++++++++
    +-----++++
    +-+++-++++
    +-+++-++++
    +++++-++++
    ++------++
    +++++-++++
    +++++-++++
    LONDON;DELHI;ICELAND;ANKARA
    */
   /*
    +-++++++++
    +-++++++++
    +-------++
    +-++++++++
    +-++++++++
    +------+++
    +-+++-++++
    +++++-++++
    +++++-++++
    ++++++++++
    AGRA;NORWAY;ENGLAND;GWALIOR
*/
   /*
    XXXXXX-XXX
    XX------XX
    XXXXXX-XXX
    XXXXXX-XXX
    XXX------X
    XXXXXX-X-X
    XXXXXX-X-X
    XXXXXXXX-X
    XXXXXXXX-X
    XXXXXXXX-X
    ICELAND;MEXICO;PANAMA;ALMATY
    */
}

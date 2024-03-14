package com.newday;

import java.util.ArrayList;
import java.util.List;

public class DiamondKata {

    public static final char START_LETTER = 'A';

    public static void main(String[] args) {
        if (args.length == 0 || !Character.isLetter(args[0].charAt(0))) {
            System.out.println("Please enter a valid alphabet [ A-Z or a-z ] character !!");
            System.exit(0);
        }
        printDiamond(Character.toUpperCase(args[0].charAt(0)));
    }

    public static ArrayList<String> printDiamond(char diamondLetter) {
        return createAndPrintDiamond(diamondLetter);
    }

    private static ArrayList<String> createAndPrintDiamond(char letter) {

        var diamondRows = new ArrayList<String>();

        // create first half diamond
        for (int i = 0; i <= letter - START_LETTER; i++) {

            char currentLetter = (char) (START_LETTER + i);
            int outerSpace = calculateOuterSpace(letter, currentLetter);
            int middleSpace = calculateMiddleSpace(currentLetter);
            String row = "%s%s%s".formatted(String.valueOf(addDashes(outerSpace)), currentLetter, addDashes(middleSpace));
            if (i > 0) row += currentLetter;
            row += addDashes(outerSpace);
            diamondRows.add(row);
        }

        // create 2nd half of the diamond and add to first half
        diamondRows.addAll(createSecondHalfDiamond(letter));

        diamondRows.forEach(System.out::println);

        return diamondRows;
    }

    private static List<String> createSecondHalfDiamond(char letter) {

        List<String> diamondRows = new ArrayList<>();

        for (int i = 1; i <= letter - START_LETTER; i++) {

            char currentLetter = (char) (letter - i);
            int outerSpace = calculateOuterSpace(letter, currentLetter);
            int middleSpace = calculateMiddleSpace(currentLetter);
            String row = "%s%s%s".formatted(String.valueOf(addDashes(outerSpace)), currentLetter, addDashes(middleSpace));
            if (i < letter - START_LETTER) row += currentLetter;
            row += addDashes(outerSpace);
            diamondRows.add(row);
        }
        return diamondRows;
    }

    public static int calculateOuterSpace(char letter, char currentLetter) {
        return letter - currentLetter;

    }

    public static int calculateMiddleSpace(char currentLetter) {
        return (currentLetter - START_LETTER) * 2 - 1;

    }

    private static StringBuffer addDashes(int spaceCount) {
        StringBuffer spaceString = new StringBuffer();
        return spaceString.append("-".repeat(Math.max(0, spaceCount)));
    }
}

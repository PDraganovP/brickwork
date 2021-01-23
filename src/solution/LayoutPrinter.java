package solution;

import java.util.Arrays;

/**
 * This class includes methods that print bricks layout of the second layer
 */
public class LayoutPrinter {
    /**
     * Print bricks layout of the second layer
     *
     * @param secondLayerLayout bricks layout of the second layer
     * @param borderSymbol      symbol used for delimiter between bricks
     */
    public void printSecondLayerLayoutWithBorders(int[][] secondLayerLayout, char borderSymbol) {
        int wallWidth = secondLayerLayout.length;
        int wallLength = secondLayerLayout[0].length;

        for (int i = 0; i < wallWidth; i++) {
            for (int j = 0; j < wallLength - 1; j++) {
                int firstValue = secondLayerLayout[i][j];
                int secondValue = secondLayerLayout[i][j + 1];
                if (j == 0) {
                    System.out.print(/*"*" +*/ firstValue);
                }
                if (firstValue != secondValue) {
                    System.out.printf(borderSymbol + "%s", secondValue);
                } else {
                    System.out.printf(" %s", secondValue);
                }
            }
            System.out.println();
        }
    }

    /**
     * Print bricks layout of the second layer
     *
     * @param secondLayerLayout bricks layout of the second layer
     * @param borderSymbol      symbol used for delimiter between bricks
     */
    public void printSecondLayerLayoutWithBorders(int[][] secondLayerLayout, String borderSymbol) {
        int wallWidth = secondLayerLayout.length;
        int wallLength = secondLayerLayout[0].length;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < wallWidth; i++) {
            for (int j = 0; j < wallLength - 1; j++) {
                int firstValue = secondLayerLayout[i][j];
                int secondValue = secondLayerLayout[i][j + 1];
                if (j == 0) {
                    System.out.print(firstValue);
                    stringBuilder.append(firstValue);
                }
                if (firstValue != secondValue) {
                    System.out.printf(borderSymbol + "%s", secondValue);
                    stringBuilder.append(borderSymbol + "" + secondValue);
                } else {
                    System.out.printf(" %s", secondValue);
                    stringBuilder.append(" " + secondValue);
                }
            }
            System.out.println();
            printLine(i, wallWidth, stringBuilder, borderSymbol);
            stringBuilder = new StringBuilder();
        }
    }

    /**
     * Print bricks layout of the second layer
     *
     * @param secondLayerLayout two dimensional array of integers that represent bricks layout
     *                          of the second layer
     */
    public void printSecondLayerLayout(int[][] secondLayerLayout) {
        // Here is used Stream API for traversing the second layer layout. We already
        // know that secondLayerLayout is array from arrays. So we traverse all
        // elements of the first array which are also arrays. Then we traverse those arrays
        // and print their values.
        Arrays.stream(secondLayerLayout)
                .forEach(ints -> {
                    Arrays.stream(ints).forEach(value -> System.out.print(value + " "));
                    System.out.println();
                });
    }

    /**
     * Return sequence with equal symbols
     *
     * @param startIndex integer
     * @param endIndex   integer
     * @param symbol     String represented by one ore more symbols
     * @return return symbol sequence that length is equal to
     * endIndex - startIndex + 1
     */
    private String multiplySymbol(int startIndex, int endIndex, String symbol) {
        StringBuilder stringBuilder = new StringBuilder();
        int difference = endIndex - startIndex;
        for (int i = 0; i < difference + 1; i++) {
            stringBuilder.append("*");
        }
        String symbolSequence = stringBuilder.toString();
        return symbolSequence;
    }

    /**
     * Print border line between bricks
     *
     * @param stringBuilder StringBuilder with characters
     * @param symbol        String represented by one ore more symbols
     */

    private void printBorderLine(StringBuilder stringBuilder, String symbol) {
        int startIndex = stringBuilder.indexOf(symbol);
        int endIndex = stringBuilder.indexOf(symbol, startIndex + 1);
        while (startIndex > -1) {
            int difference = endIndex - startIndex;
            if (difference > 3) {
                String symbolSequence = multiplySymbol(startIndex, endIndex, symbol);
                stringBuilder.replace(startIndex, endIndex + 1, symbolSequence);
            }
            startIndex = endIndex;
            endIndex = stringBuilder.indexOf(symbol, startIndex + 1);
        }
        String line = stringBuilder.toString();
        String borderLine = line.replaceAll("\\d", " ");
        System.out.println(borderLine);
    }


    /**
     * Print end to end line or intercepted line in case the brick is
     * horizontal or vertical
     *
     * @param currentLine   integer that show which is the current line
     * @param stringBuilder StringBuilder with characters
     * @param symbol        String represented by one or more symbols
     */
    private void printLine(int currentLine, int wallWidth, StringBuilder stringBuilder, String symbol) {
        if (currentLine % 2 == 0) {
            printBorderLine(stringBuilder, symbol);
        } else if (!(wallWidth - 1 == currentLine)) {
            int symbolsLength = stringBuilder.length();
            String endToEndLine = multiplySymbol(1, symbolsLength, symbol);
            System.out.println(endToEndLine);
        }
    }
}


package solution;

import static solution.ProgramConstants.*;

/**
 * The class runs program that has to find bricks layout of the second layer.
 * It must be created in a way that no brick in it lies exactly on a brick from the first
 * layer. For this purpose the program use first layer layout to create character representation
 * of the second layer layout. After that the character representation is changed to numeral
 * representation ot the second layer layout.
 */
public class MainProgram {
    public static void main(String[] args) {
        System.out.println(PLEASE_ENTER_PARAMETERS);
        UserInput userInput = new UserInput();
        int[] wallSize = userInput.getWallSize();
        int wallWidth = wallSize[0];
        int wallLength = wallSize[1];

        int[][] firstLayerLayout = userInput.getFirstLayerLayout(wallWidth, wallLength);

        CharacterRepresentationOfTheLayout charactersLayout = new CharacterRepresentationOfTheLayout();
        char[][] secondLayerWithCharacters = charactersLayout.
                createSecondLayerLayoutWithCharacters(firstLayerLayout);

        NumeralRepresentationOfTheLayout numeralLayout = new NumeralRepresentationOfTheLayout();
        int[][] secondLayerLayoutWitNumbers = numeralLayout
                .createBricksLayoutWithNumbers(secondLayerWithCharacters);

        //Print bricks layout of the second layer
        LayoutPrinter layoutPrinter = new LayoutPrinter();
        layoutPrinter.printSecondLayerLayout(secondLayerLayoutWitNumbers);
        System.out.println();

        //Print bricks layout of the second layer with borders
        // Variant I
        layoutPrinter.printSecondLayerLayoutWithBorders(secondLayerLayoutWitNumbers, "*");

        //Print bricks layout of the second layer with borders
        // Variant II
        // layoutPrinter.printSecondLayerLayoutWithBorders(secondLayerLayoutWitNumbers, '*');
    }
}

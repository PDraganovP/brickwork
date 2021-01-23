package solution;

import java.util.Scanner;

import static solution.ProgramConstants.*;

/**
 * The class includes methods that read the user input
 * N and M(wall width and wall length) and the  first layer layout
 */
public class UserInput {
    Scanner scanner = new Scanner(System.in);

    /**
     * Return integer array with N and M after they were read from the console
     * and validated  after that
     *
     * @return integer array that contains N(wall width) and M(wall length)
     */
    public int[] getWallSize() {
        String lineWithWallSize = this.scanner.nextLine();
        String[] wallSizeInput = lineWithWallSize.split("\\s+");
        int wallWidth = Integer.parseInt(wallSizeInput[0]);//n
        int wallLength = Integer.parseInt(wallSizeInput[1]);//m
        int[] wallSize = new int[2];
        UserInputValidator userInputValidator = new UserInputValidator();
        boolean isSizeCorrect = userInputValidator.isWallSizeCorrect(wallWidth, wallLength);
        // Here is used recursion if the user input is not correct the getWallSize() method
        // call itself  till the user insert correct data
        if (!isSizeCorrect) {
            return getWallSize();
        }
        wallSize[0] = wallWidth;
        wallSize[1] = wallLength;

        return wallSize;
    }

    /**
     * Return two dimensional array of integers that represent
     * bricks layout of the first layer after validation
     *
     * @param wallWidth  number N that represent width of the wall
     * @param wallLength number M that represent length of the wall
     * @return two dimensional array of integers that
     * represent bricks layout of the first layer
     */
    public int[][] getFirstLayerLayout(int wallWidth, int wallLength) {
        int[][] bricksLayoutInTheFirstLayer = readFirstLayerLayoutFromTheConsole(wallWidth, wallLength);
        // Here we validate if first layer layout is correct. This means the layout has
        // only bricks with size 1 x 2
        UserInputValidator userInputValidator = new UserInputValidator();
        boolean isFirstLayerLayoutCorrect = userInputValidator.isFirstLayerLayoutCorrect(bricksLayoutInTheFirstLayer);
        // If the user input is not correct the method getFirstLayerLayout() call itself ( this
        // is example of recursion)
        if (!isFirstLayerLayoutCorrect) {
            return getFirstLayerLayout(wallWidth, wallLength);
        }
        return bricksLayoutInTheFirstLayer;
    }

    /**
     * Return two dimensional array of integers that represent
     * bricks layout of the first layer read form the console
     *
     * @param wallWidth  number N that represent width of the wall
     * @param wallLength number M that represent length of the wall
     * @return two dimensional array of integers
     * that represent bricks layout of the first layer
     */
    private int[][] readFirstLayerLayoutFromTheConsole(int wallWidth, int wallLength) {
        int[][] firstLayerLayout = new int[wallWidth][wallLength];
        for (int i = 0; i < wallWidth; i++) {
            String bricksLine = this.scanner.nextLine();
            String[] bricks = bricksLine.split("\\s+");
            // Here is used recursion in case the user input is not equal to the wall length
            if (!(bricks.length == wallLength)) {
                System.out.println(PLEASE_ENTER_CORRECT_NUMBER_OF_THE_WIDTH_ELEMENTS);
                return readFirstLayerLayoutFromTheConsole(wallWidth, wallLength);
            }

            for (int j = 0; j < wallLength; j++) {
                int halfBrick = Integer.parseInt(bricks[j]);
                firstLayerLayout[i][j] = halfBrick;
            }
        }
        return firstLayerLayout;
    }
}

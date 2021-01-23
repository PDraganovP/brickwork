package solution;

import static solution.ProgramConstants.*;

/**
 * This class includes methods that validate the user input
 */
public class UserInputValidator {

    /**
     * Returns true if the user inserted correct first layer layout else return false.
     *
     * @param firstLayerLayout first layer layout represent the user input saved in
     *                         two dimensional array of integers
     * @return true if first layer layout is correctly inserted from the user else
     * return false
     */
    public boolean isFirstLayerLayoutCorrect(int[][] firstLayerLayout) {
        int wallWidth = firstLayerLayout.length;
        int wallLength = firstLayerLayout[0].length;
        int sum = 0;
        for (int i = 0; i < wallWidth; i++) {
            for (int j = 0; j < wallLength; j++) {
                sum += firstLayerLayout[i][j];
            }
        }
        double bricksNumber = (wallWidth * wallLength) / 2;
        // Here we use arithmetic progression that will help us to calculate sum
        // of all numbers which represent our bricks(as we know bricks are marked
        // with whole numbers ranging from 1 to the total numbers of the bricks)
        double halfSumOfTheBricksNumbers = ((1 + bricksNumber) / 2) * bricksNumber;
        // As we know each brick has two halves with equal numbers. Because of this we
        // have to multiply halfSumOfTheBricksNumbers by 2
        double totalSumOfTheBrickNumbers = halfSumOfTheBricksNumbers * 2;

        if (totalSumOfTheBrickNumbers != sum) {
            System.out.println(YOUR_INPUT_HAS_BRICKS_WITH_SIZE_DIFFERENT_THAN_1_X_2);
            return false;
        }
        return true;
    }

    /**
     * Returns true if the user inserted correct values of the wall width(N)
     * and wall length(M) else method return false
     *
     * @param wallWidth  number N that represent width of the wall
     * @param wallLength number M that represent length of the wall
     * @return true if N and M are correctly inserted from the user
     * else return false
     */
    public boolean isWallSizeCorrect(int wallWidth, int wallLength) {
        boolean isWallWidthEvenNumber = (wallWidth % 2) == 0;
        boolean isWallLengthEvenNumber = (wallLength % 2) == 0;
        boolean isWallWidthLessThanOneHundred = wallWidth < 100;
        boolean isWallLengthLessThanOneHundred = wallLength < 100;
        boolean isWallWidthGreaterThanOrEqualToTwo = wallWidth >= 2;
        boolean isWallLengthGreaterThanOrEqualToTwo = wallLength >= 2;

        if (!(isWallWidthGreaterThanOrEqualToTwo && isWallLengthGreaterThanOrEqualToTwo)) {
            System.out.println(N_AND_M_HAVE_TO_BE_GREATER_THAN_OR_EQUAL_TO_TWO);
            return false;
        } else if (!(isWallWidthEvenNumber && isWallLengthEvenNumber)) {
            System.out.println(N_AND_M_HAVE_TO_BE_EVEN_NUMBERS);
            return false;

        } else if (!(isWallWidthLessThanOneHundred && isWallLengthLessThanOneHundred)) {
            System.out.println(N_AND_M_HAVE_TO_BE_LESS_THAN_ONE_HUNDRED);
            return false;
        }

        return true;
    }
}

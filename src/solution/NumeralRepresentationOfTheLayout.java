package solution;

/**
 * This class includes method that create numeral representation of the
 * bricks layout
 */
public class NumeralRepresentationOfTheLayout {
    /**
     * Return two dimensional array of integers where halves of the same brick have equal
     * number. This number can be in range from 1 to total number of bricks in the layout.
     *
     * @param characterPresentationOfTheBricksLayout two dimensional array of characters
     *                                               where a half brick is represented with
     *                                               'V' or 'H'. For example if we have
     *                                               brick in horizontal position its
     *                                               representation is 'H' beside'H'. If
     *                                               the brick is vertical its representation
     *                                               is 'V' upon 'V'
     * @return two dimensional array of integers where the halves of the same brick have equal
     * number.
     */
    public int[][] createBricksLayoutWithNumbers(char[][] characterPresentationOfTheBricksLayout) {
        int wallWidth = characterPresentationOfTheBricksLayout.length;
        int wallLength = characterPresentationOfTheBricksLayout[0].length;
        int[][] numberRepresentationOfTheLayout = new int[wallWidth][wallLength];
        // brickCounter gives equal number for both halves of the same brick
        int brickCounter = 1;
        for (int i = 0; i < wallWidth; i += 2) {
            for (int j = 0; j < wallLength; j++) {
                if (characterPresentationOfTheBricksLayout[i][j] == 'V') {
                    numberRepresentationOfTheLayout[i][j] = brickCounter;
                    numberRepresentationOfTheLayout[i + 1][j] = brickCounter;
                    brickCounter++;
                } else if (characterPresentationOfTheBricksLayout[i][j] == 'H' && numberRepresentationOfTheLayout[i][j] == 0) {
                    numberRepresentationOfTheLayout[i][j] = brickCounter;
                    numberRepresentationOfTheLayout[i][j + 1] = brickCounter;
                    brickCounter++;
                    numberRepresentationOfTheLayout[i + 1][j] = brickCounter;
                    numberRepresentationOfTheLayout[i + 1][j + 1] = brickCounter;
                    brickCounter++;
                }
            }
        }
        return numberRepresentationOfTheLayout;
    }
}

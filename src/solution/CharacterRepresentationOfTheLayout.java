package solution;

/**
 * This class includes methods which create character representation of the brick layout
 */
public class CharacterRepresentationOfTheLayout {
    /**
     * Returns two dimensional array of characters that represent bricks layout of the
     * second layer. Horizontal bricks are represented as 'H' beside 'H' and vertical bricks
     * are represented as 'V' upon 'V'
     *
     * @param bricksLayoutOfTheFirstLayer two dimensional array of integers that represent
     *                                    brick layout of the first layer. Every single brick has
     *                                    two halves with equal numbers. The numbers can be
     *                                    in range from 1 to total number of the bricks
     *                                    in the layout
     * @return two dimensional array of characters  where a half brick is represented with
     * 'V' or 'H'. For example if we have  brick in horizontal position its  representation
     * is 'H' beside 'H'. If the brick is vertical its representation is 'V' upon 'V'
     */
    public char[][] createSecondLayerLayoutWithCharacters(int[][] bricksLayoutOfTheFirstLayer) {
        int wallWidth = bricksLayoutOfTheFirstLayer.length;
        int wallLength = bricksLayoutOfTheFirstLayer[0].length;

        CharacterRepresentationOfTheLayout characterRepresentationOfTheLayout = new CharacterRepresentationOfTheLayout();

        char[][] characterPresentationOfTheLayout = characterRepresentationOfTheLayout
                .createBricksLayoutWithCharacters(bricksLayoutOfTheFirstLayer);

        char[][] bricksLayoutOfTheSecondLayer = new char[wallWidth][wallLength];
        for (int i = 0; i < wallWidth; i += 2) {
            for (int j = 0; j < wallLength; j += 2) {
                char firstHalf = characterPresentationOfTheLayout[i][j];
                char secondHalf = characterPresentationOfTheLayout[i][j + 1];
                if (firstHalf == 'H' && secondHalf == 'H') {
                    addVerticalBricks(bricksLayoutOfTheSecondLayer, i, j);
                } else if (firstHalf == 'V' && secondHalf == 'V') {
                    addHorizontalBricks(bricksLayoutOfTheSecondLayer, i, j);
                } else if ((firstHalf == 'V' && secondHalf == 'H') || (firstHalf == 'H' && secondHalf == 'V')) {
                    addHorizontalBricks(bricksLayoutOfTheSecondLayer, i, j);
                }
            }
        }
        return bricksLayoutOfTheSecondLayer;
    }

    /**
     * Return two dimensional array of characters represented by 'H' and 'V'
     *
     * @param numeralRepresentationOfTheLayout two dimensional array of integers that represent
     *                                         brick layout. Every single brick has two halves
     *                                         with equal numbers. The number can be in range
     *                                         from 1 to total number of the bricks in the layout
     * @return two dimensional array of characters  where a half brick is represented with
     * 'V' or 'H'. For example if we have  brick in horizontal position its  representation
     * is 'H' beside 'H'. If the brick is vertical its representation is 'V' upon 'V'
     */
    private char[][] createBricksLayoutWithCharacters(int[][] numeralRepresentationOfTheLayout) {
        int wallWidth = numeralRepresentationOfTheLayout.length;
        int wallLength = numeralRepresentationOfTheLayout[0].length;
        boolean isPositionHorizontal = false;
        boolean isPositionVertical = false;

        char[][] characterRepresentationOfTheLayout = new char[wallWidth][wallLength];
        for (int i = 0; i < wallWidth; i += 2) {
            for (int j = 0; j < wallLength; j++) {
                if (j != (wallLength - 1)) {
                    isPositionHorizontal = numeralRepresentationOfTheLayout[i][j] == numeralRepresentationOfTheLayout[i][j + 1];
                }
                if (i != (wallWidth - 1)) {
                    isPositionVertical = numeralRepresentationOfTheLayout[i][j] == numeralRepresentationOfTheLayout[i + 1][j];
                }

                if (isPositionHorizontal) {
                    addHorizontalBricks(characterRepresentationOfTheLayout, i, j);
                } else if (isPositionVertical) {
                    addVerticalBrick(characterRepresentationOfTheLayout, i, j);
                }
                isPositionHorizontal = false;
                isPositionVertical = false;
            }
        }
        return characterRepresentationOfTheLayout;
    }

    /**
     * This method add 'H' to the half brick when it is with horizontal position
     *
     * @param characterRepresentationOfTheLayout two dimensional array of characters where are added
     *                                           vertical and/or horizontal bricks represented by
     *                                           'H' and/or 'V'
     * @param i                                  position of the half brick in  the wall width(N)
     * @param j                                  position of the half brick in  the wall length(N)
     */
    private void addHorizontalBricks(char[][] characterRepresentationOfTheLayout, int i, int j) {
        characterRepresentationOfTheLayout[i][j] = 'H';
        characterRepresentationOfTheLayout[i][j + 1] = 'H';
        characterRepresentationOfTheLayout[i + 1][j] = 'H';
        characterRepresentationOfTheLayout[i + 1][j + 1] = 'H';
    }

    /**
     * This method add 'V' to the half brick when it is with vertical position
     *
     * @param characterRepresentationOfTheLayout two dimensional array of characters where are added
     *                                           vertical and/or horizontal bricks represented by
     *                                           'H' and/or 'V'
     * @param i                                  position of the half brick in  the wall width(N)
     * @param j                                  position of the half brick in  the wall length(N)
     */
    private void addVerticalBricks(char[][] characterRepresentationOfTheLayout, int i, int j) {
        characterRepresentationOfTheLayout[i][j] = 'V';
        characterRepresentationOfTheLayout[i][j + 1] = 'V';
        characterRepresentationOfTheLayout[i + 1][j] = 'V';
        characterRepresentationOfTheLayout[i + 1][j + 1] = 'V';
    }

    /**
     * This method add 'V' to the half brick when it is with vertical position
     *
     * @param characterRepresentationOfTheLayout two dimensional array of characters where are added
     *                                           vertical and/or horizontal bricks represented by
     *                                           'H' and/or 'V'
     * @param i                                  position of the half brick in  the wall width(N)
     * @param j                                  position of the half brick in  the wall length(N)
     */
    private void addVerticalBrick(char[][] characterRepresentationOfTheLayout, int i, int j) {
        characterRepresentationOfTheLayout[i][j] = 'V';
        characterRepresentationOfTheLayout[i + 1][j] = 'V';
    }
}

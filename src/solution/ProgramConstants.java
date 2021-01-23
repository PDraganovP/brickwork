package solution;

/**
 * This class is used for declaring of the program constants. The class is final this means
 * that it can not be extended. All constants are declared with keywords static and final.
 * Constants can be used without creating of the class instance (because of static keyword)
 * and they can not be override(because of final keyword)
 */
public final class ProgramConstants {
    public static final String N_AND_M_HAVE_TO_BE_LESS_THAN_ONE_HUNDRED = "Please enter " +
            "correct wall size.\nN and M have to be less than 100";
    public static final String N_AND_M_HAVE_TO_BE_EVEN_NUMBERS = "Please enter correct wall size.\n" +
            "N and M have to be even numbers";
    public static final String N_AND_M_HAVE_TO_BE_GREATER_THAN_OR_EQUAL_TO_TWO = "Please enter " +
            "correct wall size.\nN and M have to be greater than or equal to 2";
    public static final String YOUR_INPUT_HAS_BRICKS_WITH_SIZE_DIFFERENT_THAN_1_X_2 = "Please " +
            "enter correct data.\nYour input has bricks with size different than 1 x 2";
    public static final String PLEASE_ENTER_PARAMETERS = "Please enter parameters for the bricks\nlayout " +
            "of the first layer";
    public static final String PLEASE_ENTER_CORRECT_NUMBER_OF_THE_WIDTH_ELEMENTS="Please enter correct number of the width elements";
}

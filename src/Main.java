import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ethan Johnson
 * For Computer Science 201: Data Structures and Algorithms
 */
class CapitalStateArray {
    /**
     * This Helper class is meant to contain the methods for interacting with
     * the capitalsStates string array.
     */
    String[][] strArray;

    /**
     * @param strArray The two-dimensional string array containing the states
     *                 and their capitals.
     */
    public CapitalStateArray(String[][] strArray) {
        this.strArray = strArray;
    }

    /**
     * This method sorts the strArray of its containing class alphabetically
     * based on the first element of each sub-array using the bubbleSort
     * algorithm.
     */
    public void bubbleSort() {
        CapitalStateArray sorted;
        for (int i = 0; i < strArray.length - 1; i++) {
            if (needsSorted(strArray[i], strArray[i + 1])) {
                System.out.println("needs sorted");
            }
        }
    }

    /**
     * @param first  The first element to be compared.
     * @param second The second element to be compared.
     * @return Returns true if the first element is alphabetically after the
     * second element. Returns false if the first element is equal to or
     * alphabetically before the second element.
     */
    private static boolean needsSorted(String[] first, String[] second) {
        int res = Arrays.toString(first).compareToIgnoreCase
                (Arrays.toString(second));
        return res > 0;
    }
}

class GuessGame {
    /* This class should contain all the methods necessary to
    initialize and play a game - including reading from the array,
    taking guesses, evaluating answers, incrementing counts,
    and output results to the user.
    */
    private final String[][] answers;
    private int correct;
    private int wrong;

    public GuessGame(String[][] answers) {
        this.answers = answers;

        correct = 0;
        wrong = 0;
        System.out.println("Let's try to guess all 50 U.S. capitals!");
    }


    public void play() {
                /* This method should iterate over every
                item in the answers list and perform
                the actual input evaluation from the user.
                */
        Scanner scanner = new Scanner(System.in);
        String res;
        for (String[] capitalState : answers) {
            System.out.printf("What is the capital of " +
                    "%s?%nGuess: %n", capitalState[1]);
            res = scanner.nextLine();
            if (res.equalsIgnoreCase(capitalState[0])) {
                correct++;
            } else {
                wrong++;
            }
        }
        this.printResults();
    }

    private void printResults() {
        System.out.printf("You answered %d correctly " +
                "and %d incorrectly.%n", correct, wrong);
    }

}

public class Main {

    public static void main(String[] args) {

        final String[][] capitalsStates = {
                {"Montgomery", "Alabama"},
                {"Juneau", "Alaska"},
                {"Phoenix", "Arizona"},
                {"Little Rock", "Arkansas"},
                {"Sacramento", "California"},
                {"Denver", "Colorado"},
                {"Hartford", "Connecticut"},
                {"Dover", "Delaware"},
                {"Tallahassee", "Florida"},
                {"Atlanta", "Georgia"},
                {"Honolulu", "Hawaii"},
                {"Boise", "Idaho"},
                {"Springfield", "Illinois"},
                {"Indianapolis", "Indiana"},
                {"Des Moines", "Iowa"},
                {"Topeka", "Kansas"},
                {"Frankfort", "Kentucky"},
                {"Baton Rouge", "Louisiana"},
                {"Augusta", "Maine"},
                {"Annapolis", "Maryland"},
                {"Boston", "Massachusetts"},
                {"Lansing", "Michigan"},
                {"St. Paul", "Minnesota"},
                {"Jackson", "Mississippi"},
                {"Jefferson City", "Missouri"},
                {"Helena", "Montana"},
                {"Lincoln", "Nebraska"},
                {"Carson City", "Nevada"},
                {"Concord", "New Hampshire"},
                {"Trenton", "New Jersey"},
                {"Santa Fe", "New Mexico"},
                {"Albany", "New York"},
                {"Raleigh", "North Carolina"},
                {"Bismarck", "North Dakota"},
                {"Columbus", "Ohio"},
                {"Oklahoma City", "Oklahoma"},
                {"Salem", "Oregon"},
                {"Harrisburg", "Pennsylvania"},
                {"Providence", "Rhode Island"},
                {"Columbia", "South Carolina"},
                {"Pierre", "South Dakota"},
                {"Nashville", "Tennessee"},
                {"Austin", "Texas"},
                {"Salt Lake City", "Utah"},
                {"Montpelier", "Vermont"},
                {"Richmond", "Virginia"},
                {"Olympia", "Washington"},
                {"Charleston", "West Virginia"},
                {"Madison", "Wisconsin"},
                {"Cheyenne", "Wyoming"},
        };

        CapitalStateArray csa = new CapitalStateArray(capitalsStates);

        // Print contents of array (line by line)
        for (String[] capitalState : csa.strArray) {
            System.out.println(Arrays.toString(capitalState));
        }

        // Bubble sort
        csa.bubbleSort();

        // Begin guesses from user and output results at the end
        GuessGame gg = new GuessGame(capitalsStates);
        gg.play();

        // Convert 2D array to hashmap

        // Display hashmap

        // Sort map using with TreeMap class

        // Begin user state/capital response


    }
}

/**
 * @author Ethan Johnson
 * For Computer Science 201: Data Structures and Algorithms
 */

import java.util.*;


/**
 * This Helper class is meant to contain the methods for interacting with
 * the capitalsStates string array.
 */
class CapitalStateArray {

    String[][] strArray;

    /**
     * Class constructor specifying the string array to be used.
     *
     * @param strArray The two-dimensional string array containing the states
     *                 and their capitals.
     */
    public CapitalStateArray(String[][] strArray) {
        /* Must use clone() or arrayCopy() here as Java treats assignments to
         objects as references and not the object itself. */
        this.strArray = strArray.clone();
    }

    /**
     * This method provides a shorthand call to print the capitals and states
     * line by line.
     */
    public void printList() {
        for (String[] capitalState : this.strArray) {
            System.out.println(Arrays.toString(capitalState));
        }
    }

    /**
     * This method sorts the strArray of its containing class alphabetically
     * based on the first element of each sub-array using the bubbleSort
     * algorithm.
     */
    public void bubbleSort() {
        boolean sorted = false;

        /* This algorithm begins by checking if the array is sorted, and
        continues to run as long is it is unsorted. Every iteration of the
        while loop, variable sorted is set to true. An inner for-loop is then
        run to iterate over the array elements. For each element, it will
        compare it to the element after itself using the needsSorted() method.
        If needsSorted() returns true, sorted will be set to false, then the
        elements will be swapped via a simple temporary variable
        implementation. If the inner for-loop iterates without ever following
        the conditional path, sorted will never be set to false and thus the
        outer while-loop will break.
         */
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < strArray.length - 1; i++) {
                if (needsSorted(strArray[i], strArray[i + 1])) {
                    sorted = false;
                    String[] temp = strArray[i];
                    strArray[i] = strArray[i + 1];
                    strArray[i + 1] = temp;
                }
            }
        }

    }


    /**
     * Returns the sorting state of two elements in a string array. It
     * returns true if the second string is alphabetically prior to the first
     * string. It returns false if the strings are the same or if the second
     * string is alphabetically after.
     *
     * @param first  The first element to be compared.
     * @param second The second element to be compared.
     * @return The sorted state of the two provided strings.
     */
    private static boolean needsSorted(String[] first, String[] second) {
        int res = Arrays.toString(first).compareToIgnoreCase
                (Arrays.toString(second));
        return res > 0;
    }

    public Map<String, String> csaToHashMap() {
        HashMap<String, String> result = new HashMap<>();
        for (String[] capitalState : this.strArray) {
            result.put(capitalState[0], capitalState[1]);
        }
        return result;
    }
}

/**
 * This class contains the methods necessary to play the guessing game and
 * output the users results.
 */
class GuessGame {
    private final String[][] answers;
    private int correct;
    private int wrong;

    /**
     * Class constructor specifying the CapitalStateArray to be used as the
     * answer list for the game.
     *
     * @param answers The two-dimensional array to be used as the answer list.
     */
    public GuessGame(CapitalStateArray answers) {
        this.answers = answers.strArray;

        correct = 0;
        wrong = 0;
        System.out.println("Let's try to guess all 50 U.S. capitals!");
    }

    /**
     * This method plays the game by initializing a scanner, iterating over
     * the answer array, and evaluating the user's input each iteration. At
     * the end of the game, the printResults() method is called to tell the
     * user how many responses were correct/incorrect.
     */
    public void play() {
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
        System.out.printf("You answered %d correctly " +
                "and %d incorrectly.%n", correct, wrong);
    }
}

/**
 * The main class of the program.
 */
public class Main {


    /**
     * The main method. Runs the program.
     *
     * @param args none
     */
    public static void main(String[] args) {

        /* String array containing all capitals and state. Normally I wouldn't
         hardcode it and instead read it in from a text file. For the sake of
         project simplicity this allows me to keep everything in one file.
         */
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

        // Construct our CapitalStateArray, passing in the raw string array
        CapitalStateArray capitalStateArray =
                new CapitalStateArray(capitalsStates);
        // Print contents of array (line by line)
        capitalStateArray.printList();
        // Bubble sort and reprint
        capitalStateArray.bubbleSort();
        capitalStateArray.printList();
        // Construct our game, passing in the capitalStateArray, then play
        GuessGame game = new GuessGame(capitalStateArray);
        game.play();
        // Convert 2D array to map
        Map<String, String> capitalStateHashMap =
                capitalStateArray.csaToHashMap();
        // Display hashmap
        System.out.println(capitalStateHashMap);
        // Sort map using with TreeMap class
        TreeMap<String, String> capitalStateTreeMap =
                new TreeMap<>(capitalStateHashMap);
        System.out.println(capitalStateTreeMap);
        // Begin user state/capital response


    }
}

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
            /* Setting the state as the key and capital as the value since
            that is how we will want to search the map by later on.
             */
            result.put(capitalState[1], capitalState[0]);
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

class CapitalResponse {
    Map<String, String> answers;

    /**
     * Class constructor specifying the answer Map<> to be used for responses.
     *
     * @param answers The map containing the answers.
     */
    public CapitalResponse(Map<String, String> answers) {
        this.answers = answers;
    }

    /**
     * This method loops until the user inputs "quit". It asks the user for a
     * state and checks if that state exists in the map. It outputs the
     * results to the user, whether it was an invalid state or the name of
     * the capital if the state was found in the map.
     */
    public void askCapital() {
        while (true) {
            System.out.println("What state would you like to know the capital" +
                    " of? (Type 'quit' to quit.)");
            Scanner scanner = new Scanner(System.in);
            String res = scanner.nextLine();
            if (Objects.equals(res, "quit")) {
                break;
            } else if (!this.answers.containsKey(res)) {
                System.out.println("That is not a state!");
            } else {
                System.out.printf("The capital of %s is %s.%n", res,
                        this.answers.get(res));
            }
        }
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
        // Construct scanner to step through program by each section
        Scanner scanner = new Scanner(System.in);

        // Introduce program
        System.out.printf("Welcome to my Java program for Computer Science " +
                "201: Data Structures and Algorithms.%nTo make the program " +
                "easier to evaluate, it interrupts itself after performing " +
                "each assigned task and waits for user input to continue " +
                "with the next one.%n(Press enter to continue.)%n");
        scanner.nextLine();

        System.out.printf("First we will construct and display the contents " +
                "of our CapitalStateArray.%n(Press enter to continue.)%n");
        scanner.nextLine();
        // Construct our CapitalStateArray, passing in the raw string array
        CapitalStateArray capitalStateArray =
                new CapitalStateArray(capitalsStates);
        // Print contents of array (line by line)
        capitalStateArray.printList();

        System.out.printf("Now that we have our CapitalStateArray " +
                "constructed, we can call our bubbleSort() method on it.%nWe " +
                "will reprint again to show the contents are sorted.%n(Press " +
                "enter to continue.)%n");
        scanner.nextLine();
        // Bubble sort and reprint
        capitalStateArray.bubbleSort();
        capitalStateArray.printList();

        System.out.printf("Now we will begin the capital guessing activity.%n" +
                "(Press enter to continue.)%n");
        scanner.nextLine();
        // Construct our game, passing in the capitalStateArray, then play
        GuessGame game = new GuessGame(capitalStateArray);
        game.play();

        System.out.printf("Wasn't that fun?%nIn fact, that was so much fun " +
                "that I think we should play again!%n(Press enter to " +
                "continue.)%n");
        scanner.nextLine();

        System.out.printf("Just kidding. I won't make you do all of that " +
                "again.%nAssuming you didn't just hold the enter key down " +
                "to skip them all.%nLets go ahead and convert our " +
                "CapitalStateArray into a hashmap using our csaToHashMap() " +
                "method.%n(Press enter to continue.)%n");
        scanner.nextLine();
        // Convert 2D array to map
        Map<String, String> capitalStateHashMap =
                capitalStateArray.csaToHashMap();
        // Display hashmap
        System.out.println(capitalStateHashMap);

        System.out.printf("Hmm, at least we can look up map elements in " +
                "constant time now.%nBut it sure would be nice to have a map " +
                "sorted by key as well.%nLet's call a TreeMap constructor " +
                "and pass our map as an argument.%nWe'll print it and see " +
                "it's sorted by key this time.%n(Press enter to continue.)%n");
        scanner.nextLine();
        // Sort map using TreeMap class
        TreeMap<String, String> capitalStateTreeMap =
                new TreeMap<>(capitalStateHashMap);
        System.out.println(capitalStateTreeMap);

        System.out.printf("Now that we have a sorted TreeMap, we can do all " +
                "kinds of efficient lookups!%nLet's exercise this by " +
                "educating ourselves on the United States capitals.%nGive the" +
                " program a state and it will search the map to find the " +
                "corresponding capital.%n(Press enter to continue.)%n");
        scanner.nextLine();
        // Begin user state/capital response
        CapitalResponse capitalResponse = new CapitalResponse(capitalStateTreeMap);
        capitalResponse.askCapital();

        System.out.printf("Wasn't that exciting?%nI'm sure you'll use this " +
                "program every day to practice remembering all of the " +
                "capitals.%nDon't worry, you won't be billed for using it" +
                ".%nAnyway, thanks for compiling and running.%nHave a nice " +
                "day :)%n(Press enter to quit.)");
        scanner.nextLine();
    }
}

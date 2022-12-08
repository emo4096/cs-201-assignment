import java.util.Arrays;
import java.util.Scanner;

public class Scratch {

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

        // Print contents of array (line by line)
        for (String[] capitalState : capitalsStates) {
            System.out.println(Arrays.toString(capitalState));
        }

        // Bubble sort
        CapitalStateArray csa = new CapitalStateArray(capitalsStates);
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

class CapitalStateArray {

    String[][] strArray;

    public CapitalStateArray(String[][] strArray) {
        this.strArray = strArray;
    }


    public void bubbleSort() {
        CapitalStateArray sorted;
        for (int i = 0; i < strArray.length - 1; i++) {
            if (strCompare(strArray[i], strArray[i + 1])) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }

    private static boolean strCompare(String[] first, String[] second) {
        int res = Arrays.toString(first).compareToIgnoreCase
                (Arrays.toString(second));
        return res <= 0;
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
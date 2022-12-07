import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Scratch {

    private static String[][] twoDimensionBubbleSort(String[][] strArray) {
        /* This method should take a 2D string array as an argument
        and return the same array sorted using the bubble sort algorithm.
        */
        return strArray;
    }

    private static void playGuessGame(String[][] answers) {
        /* When called, this method should begin prompting
        the user to guess the capitals of each state.
        As the user guesses, it should evaluate each guess
        and increment a correct/incorrect counter.
        Upon completion of the guessing, it should tell
        the user how many answers were correct/incorrect.
        */
        class GuessGame {
            /* This class should contain all the methods necessary to
            initialize and play a game - including reading from the array,
            taking guesses, evaluating answers, incrementing counts,
            and output results to the user.
            */
            private int correct;
            private int wrong;


            private GuessGame() {
                correct = 0;
                wrong = 0;
                System.out.println("Let's try to guess all 50 U.S. capitals!");
            }

            private void printResults() {
                System.out.println(String.format("You answered %d correctly " +
                        "and %d incorrectly.", correct, wrong));
            }

            private void play() {
                /* This method should iterate over every
                item in the answers list and perform
                the actual input evaluation from the user.
                */
                Scanner scanner = new Scanner(System.in);
                String res;
                for (String[] capitalState : answers) {
                    System.out.println(String.format("What is the capital of " +
                            "%s?%nGuess: ", capitalState[1]));
                    res = scanner.nextLine();
                    if (Objects.equals(res.toLowerCase(),
                            capitalState[0].toLowerCase())) {
                        System.out.println("correct");
                        correct++;
                    } else {
                        System.out.println("wrong");
                        wrong++;
                    }
                }
            }
        }
        GuessGame game = new GuessGame();
        game.play();
        game.printResults();
    }


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

        // Begin guesses from user and output results at the end
        playGuessGame(capitalsStates);

        // Convert 2D array to hashmap

        // Display hashmap

        // Sort map using with TreeMap class

        // Begin user state/capital response


    }
}
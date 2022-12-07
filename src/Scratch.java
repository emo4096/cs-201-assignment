import java.util.Arrays;

public class Scratch {

    static void printState(String[] capitalState) {
        System.out.printf("The capital of %s is %s.%n", capitalState[1], capitalState[0]);
    }


    public static void main(String[] args) {

        String[][] capitalsStates = {
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

        printState(capitalsStates[0]);

        // Print contents of array (line by line)

        for (String[] capitalState : capitalsStates) {
            System.out.println(Arrays.toString(capitalState));
        }

        // Bubble sort

        // Begin user guessing

        // Output results

        // Convert 2D array to hashmap

        // Display hashmap

        // Sort map using with TreeMap class

        // Begin user state/capital response


    }
}
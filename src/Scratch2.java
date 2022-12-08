import java.util.Arrays;

public class Scratch2 {
    public static void main(String[] args) {
        System.out.println("abc".compareToIgnoreCase("abc"));

        String[][] strArray = {
                {"abc", "test"},
                {"ab", "test"},
                {"ab", "test"},
                {"abd", "test"},
                {"ddd", "test"},
                {"c", "test"}
        };

        CapitalStateArrayTest csa = new CapitalStateArrayTest(strArray);
        csa.bubbleSort();
    }
}

class CapitalStateArrayTest {

    String[][] strArray;

    public CapitalStateArrayTest(String[][] strArray) {
        this.strArray = strArray;
    }


    public void bubbleSort() {
        CapitalStateArrayTest sorted;
        for (int i = 0; i < strArray.length - 1; i++) {
            strCompare(strArray[i], strArray[i + 1]);
        }
    }

    private static void strCompare(String[] first, String[] second) {
        int res = Arrays.toString(first).compareToIgnoreCase
                (Arrays.toString(second));

        if (res > 0) {
            System.out.println("Out of order");
        } else {
            System.out.println("In order");
        }
    }
}
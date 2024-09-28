package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    public static int MAX_OPEN_BRACKETS = 0;

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfOptions = Integer.parseInt(reader.readLine());
            MAX_OPEN_BRACKETS = numberOfOptions;
            int numberOfOpenBrackets = 0;
            int numberOfClosedBrackets = 0;
            buildAllOptionsAndPrintIt(numberOfOptions * 2, "", numberOfOpenBrackets, numberOfClosedBrackets);
        }
    }

    private static void buildAllOptionsAndPrintIt(int numberOfOptions, String prefix, int numberOfOpenBrackets, int numberOfClosedBrackets) {
        if (numberOfOptions == 0) {
                System.out.println(prefix);
        } else {
            if (numberOfOpenBrackets < MAX_OPEN_BRACKETS)
                buildAllOptionsAndPrintIt(numberOfOptions - 1, prefix + "(", numberOfOpenBrackets + 1, numberOfClosedBrackets);
            if (numberOfOpenBrackets > numberOfClosedBrackets)
                buildAllOptionsAndPrintIt(numberOfOptions - 1, prefix + ")", numberOfOpenBrackets, numberOfClosedBrackets + 1);
        }
    }

}


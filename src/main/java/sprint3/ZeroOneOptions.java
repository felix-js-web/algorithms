package sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZeroOneOptions {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfOptions = Integer.parseInt(reader.readLine());
            buildAllOptionsAndPrintIt(numberOfOptions, "");
        }
    }

    private static void buildAllOptionsAndPrintIt(int numberOfOptions, String prefix) {
        if (numberOfOptions == 0) {
            System.out.println(prefix);
        } else {
            buildAllOptionsAndPrintIt(numberOfOptions - 1, prefix + "0");
            buildAllOptionsAndPrintIt(numberOfOptions - 1, prefix + "1");
        }
    }

}

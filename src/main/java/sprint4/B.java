package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class B {

    public static Map<Integer, String> valueMap = Map.of(2, "abc",
            3, "def",
            4, "ghi",
            5, "jkl",
            6, "mno",
            7, "pqrs",
            8, "tuv",
            9, "wxyz");

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String numbersString = reader.readLine();
            int numberOfOptions = numbersString.length();
            buildAllOptionsAndPrint("", numberOfOptions, numbersString);
        }
    }

    private static void buildAllOptionsAndPrint(String prefix, int numberOfOptions, String numbersString) {
        if (numberOfOptions == 0) {
            System.out.print(prefix + " ");
            return;
        }
        Integer numberForAnalysis = Integer.parseInt(numbersString.substring(0, 1));
        String mapString = valueMap.get(numberForAnalysis);
        for (int i = 0; i < mapString.length(); i++) {
            buildAllOptionsAndPrint(prefix + mapString.charAt(i), numberOfOptions - 1, numbersString.substring(1));
        }
    }

}


package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LWhatIhaveNoIdea {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfItems = readInt(reader);
            List<Integer> bubbleSortArray = readList(reader);
            buildBubbleSort(numberOfItems, bubbleSortArray.toArray(new Integer[0]));
        }
    }

    private static void buildBubbleSort(int numberOfItems, Integer[] numbersArray) {
        var everPrinted = false;
        for (int i = numberOfItems - 1; i > 0; i--) {
            int j = 1;
            var moved = false;
            while (j <= i) {
                if (numbersArray[j] < numbersArray[j - 1]) {
                    int tempValue = numbersArray[j - 1];
                    numbersArray[j - 1] = numbersArray[j];
                    numbersArray[j] = tempValue;
                    moved = true;
                }
                j++;
            }
            if (moved) {
                everPrinted = true;
                printArray(numbersArray);
            }
            else{
                break;
            }
        }
        if (!everPrinted) {
            printArray(numbersArray);
        }
    }

    private static void printArray(Integer[] numbersArray) {
        StringBuilder sb = new StringBuilder();
        for (int num : numbersArray) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        String valuesString = reader.readLine();
        if (valuesString.isEmpty()) return new ArrayList<>();
        return Arrays.asList(valuesString.split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static List<Integer> readList(String valuesString) throws IOException {
        return Arrays.asList(valuesString.split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
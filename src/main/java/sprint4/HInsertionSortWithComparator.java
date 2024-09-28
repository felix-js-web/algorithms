package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HInsertionSortWithComparator {


    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfNumbers = 6;//readInt(reader);
            List<Integer> numbersList = readList("9 10 1 1 1 6");
            buildBiggestNumberStringCompare(numberOfNumbers, numbersList.toArray(new Integer[0]));
        }
    }

    private static void buildBiggestNumber(int numberOfNumbers, Integer[] numbersList) {
        System.out.println("BEFORE SORTING" + Arrays.toString(numbersList));
        for (int i = 1; i < numberOfNumbers; i++) {
            int j = i;
            int movingValue = numbersList[j];
            while (j > 0 && numbersList[j - 1] > numbersList[j]) {
                numbersList[j] = numbersList[j - 1];
                numbersList[j - 1] = movingValue;
                j--;
            }
        }
        System.out.println("AFTER SORTING" + Arrays.toString(numbersList));
    }

    private static void buildBiggestNumberStringCompare(int numberOfNumbers, Integer[] numbersList) {
        System.out.println("BEFORE SORTING" + Arrays.toString(numbersList));
        for (int i = 1; i < numberOfNumbers; i++) {
            int j = i;
            int movingValue = numbersList[j];
            while (j > 0 && comparatorString.compare(numbersList[j - 1], numbersList[j]) > 0) {
                numbersList[j] = numbersList[j - 1];
                numbersList[j - 1] = movingValue;
                j--;
            }
        }
        System.out.println("AFTER SORTING" + Arrays.toString(numbersList));
    }

    public static Comparator<Integer> comparator = (num1, num2) -> - num1.compareTo(num2);

    public static Comparator<Integer> comparatorString = (num1, num2) -> -String.valueOf(num1).compareTo(String.valueOf(num2));

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

package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class H {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfNumbers = readInt(reader);
            List<Integer> numbersList = readList(reader);
            buildBiggestNumber(numberOfNumbers, numbersList);
        }
    }

    private static void buildBiggestNumber(int numberOfNumbers, List<Integer> numbersList) {
        int[] cards = numbersList.stream().mapToInt(Integer::intValue).toArray();
        insertion_sort_by_comparator(cards, comparator);
        for (int i = 0; i < numberOfNumbers; i++) {
            System.out.print(cards[i]);
        }
    }

    public static Comparator<Integer> comparator = (card1, card2) ->
    {
        String card1S = String.valueOf(card1);
        String card2S = String.valueOf(card2);
        return - Integer.valueOf(card1S + card2S).compareTo(Integer.valueOf(card2S + card1S));
    };

    static void insertion_sort_by_comparator(int[] array, Comparator<Integer> less) {
        for (int i = 1; i < array.length; i++) {
            int item_to_insert = array[i];
            int j = i;
            // заменим сравнение item_to_insert < array[j-1] на компаратор less
            while (j > 0 && less.compare(item_to_insert, array[j - 1]) < 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = item_to_insert;
        }
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
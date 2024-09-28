package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class M {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] arr = new int[]{1, 2, 3, 4, 5, 9, 8, 7, 6};
            mergeSort(arr);
            System.out.println(Arrays.toString(mergeSort(arr)));
        }
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {  // базовый случай рекурсии
            return array;
        }

        // запускаем сортировку рекурсивно на левой половине
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, array.length/2));

        // запускаем сортировку рекурсивно на правой половине
        int[] right = mergeSort(Arrays.copyOfRange(array, array.length/2, array.length));

        // заводим массив для результата сортировки
        int[] result = new int[array.length];

        // сливаем результаты
        int l = 0, r = 0, k = 0;
        while (l < left.length && r < right.length) {
            // выбираем, из какого массива забрать минимальный элемент
            if (left[l] <= right[r]) {
                result[k] = left[l];
                l++;
            } else {
                result[k] = right[r];
                r++;
            }
            k++;
        }

        // Если один массив закончился раньше, чем второй, то
        // переносим оставшиеся элементы второго массива в результирующий
        while (l < left.length) {
            result[k] = left[l];   // перенеси оставшиеся элементы left в result
            l++;
            k++;
        }
        while (r < right.length) {
            result[k] = right[r];  // перенеси оставшиеся элементы right в result
            r++;
            k++;
        }

        return result;
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
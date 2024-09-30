package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class L {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfDays = 6;//readInt(reader);
            Integer[] daysValuesList = readList("1 2 4 4 4 4").toArray(new Integer[0]);
            int bicyclePrice = 3;//readInt(reader);
            System.out.print(buildWhichDays(numberOfDays, daysValuesList, 0, daysValuesList.length, bicyclePrice));
            System.out.print(" " + buildWhichDays(numberOfDays, daysValuesList, 0, daysValuesList.length, bicyclePrice * 2));
            System.out.print(findFirstDay(daysValuesList ,bicyclePrice));
            System.out.print(findFirstDay(daysValuesList ,bicyclePrice*2));
        }
    }

    private static int findFirstDay(Integer[] savings, int target) {
        int result = -1;
        int left = 0;
        int right = savings.length - 1;
        while (left <=right){
            int mid = left + (right - left)/2;
            if (savings[mid]>=target){
                result = mid+1;
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static int buildWhichDays(int numberOfDays, Integer[] array, int left, int right, int bicyclePrice) {

        if (right - left < 0) {
            return -1;
        }
        if (right - left == 0 && left < array.length) {
            if (array[left] >= bicyclePrice) {
                return left + 1;
            } else {
                return -1;
            }
        }
        if (right - left == 1) {
            if (array[left] >= bicyclePrice) {
                return left + 1;
            } else {
                if (right < array.length && array[right] >= bicyclePrice) {
                    return right + 1;
                }
                return -1;
            }
        }
        int mid = (left + right) / 2;
        if (mid ==array.length){
            return -1;
        }
        if (array[mid] < bicyclePrice) {
            return buildWhichDays(numberOfDays, array, mid + 1, right, bicyclePrice);
        } else {
            return buildWhichDays(numberOfDays, array, left, mid, bicyclePrice);
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
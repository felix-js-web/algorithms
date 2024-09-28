package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class F {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfSides = readInt(reader);
            List<Integer> sidesList = readList(reader);
            System.out.println(checkHowManyTriangles(numberOfSides, sidesList));
        }
    }

    private static int checkHowManyTriangles(int numberOfSides, List<Integer> sidesList) {
        int maxPerimeter = 0;
        Collections.sort(sidesList);
        if (sidesList.size() > 2) {
            for (int i = numberOfSides - 1; i >= 2; i--) {
                for (int j = i - 1; j >= 1; j--) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (sidesList.get(k)+sidesList.get(j)> sidesList.get(i)){
                            return sidesList.get(k)+sidesList.get(j)+ sidesList.get(i);
                        }
                    }
                }
            }
        }
        return maxPerimeter;
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
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
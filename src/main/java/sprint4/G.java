package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class G {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfClothes = readInt(reader);
            List<Integer> coloursList = readList(reader);
            build012String(numberOfClothes, coloursList);
        }
    }

    private static void build012String(int numberOfClothes, List<Integer> coloursList) {
        if (numberOfClothes==0) return;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < coloursList.size(); i++) {
            if (coloursList.get(i) == 0) count0++;
            if (coloursList.get(i) == 1) count1++;
            if (coloursList.get(i) == 2) count2++;
        }

        for (int i = 0; i < count0; i++) {
            System.out.print("0 ");
        }
        for (int i = 0; i < count1; i++) {
            System.out.print("1 ");
        }
        for (int i = 0; i < count2; i++) {
            System.out.print("2 ");
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
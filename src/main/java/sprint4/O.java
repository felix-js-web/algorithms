package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class O {

    public static void main(String[] args) throws IOException {
        int n = 0;
        List<Integer> pairsArrList = new ArrayList<>();
        int k = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = readInt(reader);
            pairsArrList = readList(reader);
            k = readInt(reader);
            Collections.sort(pairsArrList);

        }

    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static List<Integer> readList(String reader) throws IOException {
        return Arrays.asList(reader.split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

}

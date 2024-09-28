package sprint4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class K {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfStudents = 5;//readInt(reader);
            List<Integer> studentIdList = readList("1 1 1 1 1");
            int kNumbers = 2;//readInt(reader);
            buildBiggestNumber(numberOfStudents, studentIdList.toArray(new Integer[0]), kNumbers);
        }
    }

    private static void buildBiggestNumber(int numberOfStudents, Integer[] studentIdList, int kNumbers) {
        Map<Integer, Integer> idIndexMap = new HashMap<>();
        for (int i = 0; i < numberOfStudents; i++) {
            idIndexMap.put(studentIdList[i], idIndexMap.getOrDefault(studentIdList[i], 0) + 1);
        }
        // Создаем список пар (ID вуза, количество студентов) и сортируем его
        List<Map.Entry<Integer, Integer>> entrySet = new ArrayList<>(idIndexMap.entrySet());
        entrySet.sort((entry1, entry2) -> {
            return -entry1.getValue().compareTo(entry2.getValue());
        });

        for (int i = 0; i < kNumbers && i < entrySet.size(); i++) {
            System.out.print(entrySet.get(i).getKey() + " ");
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
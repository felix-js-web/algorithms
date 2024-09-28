package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class E {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> numberOfHousesAndMoneyList = readList(reader);
            int numberOfHouses = numberOfHousesAndMoneyList.get(0);
            int cashMoney = numberOfHousesAndMoneyList.get(1);
            List<Integer> housePriceList = readList(reader);
            System.out.println(checkHowManyHouses(numberOfHouses, cashMoney, housePriceList));
        }
    }

    private static int checkHowManyHouses(int numberOfHouses, int cashMoney, List<Integer> housePriceList) {
        int happyHouses = 0;
        int tempSum = 0;
        Collections.sort(housePriceList);
        for (int i : housePriceList){
            if ((tempSum + i) <= cashMoney){
                tempSum += i;
                happyHouses++;
            } else {
                break;
            }
        }
        return happyHouses;
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
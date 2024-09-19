//https://contest.yandex.ru/contest/22450/run-report/117468079/
package sprint1finals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {

    static int numberOfMatrixRaws = 4;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int k = readInt(reader); // K is 0 to 5 no need to control it but just FYI
            String[] stringArray = new String[numberOfMatrixRaws];
            for (int i = 0; i < numberOfMatrixRaws; i++) {
                stringArray[i] = readString(reader); // K is 0 to 5 no need to control it but just FYI
            }
            Integer resultNum = getMaxNumberfromKAndStringArray(stringArray, k);
            writer.write(resultNum + " ");
        }
    }

    private static Integer getMaxNumberfromKAndStringArray(String[] stringArray, int k) {
        int resultNumber = 0;
        int[] intArray = new int[10];
        for (int i = 0; i < numberOfMatrixRaws; i++) {
            for (int j = 0; j < numberOfMatrixRaws; j++) {
                char symbol = stringArray[i].charAt(j);
                if (Character.isDigit(symbol)) {
                    intArray[Character.getNumericValue(symbol)]++;
                }
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (intArray[i] != 0 && k * 2 >= intArray[i]) {
                resultNumber++;
            }
        }
        return resultNumber;
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
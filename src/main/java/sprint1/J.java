package sprint1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class J {

    public static List<Integer> resultList = new ArrayList<>();

    private static List<Integer> factorize(int n) {
        // Ваше решение
        var found = false;
        var foundOnI = 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                resultList.add(i);
                found = true;
                foundOnI = i;
                break;
            }
        }
        if (!found) {
            resultList.add(n);
        } else {
            factorize(n / foundOnI);
        } ;
        return resultList;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = readInt(reader);
            List<Integer> factorization = factorize(n);
            for (int elem : factorization) {
                writer.write(elem + " ");
            }
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
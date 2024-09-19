package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class G {

    private static String getBinaryNumber(int n) {
        // Ваше решение
        var sb = new StringBuilder();
        if (n < 2) return Integer.toString(n);
        while (n != 0) {
            if (n < 2) return Integer.toString(n) + sb.toString();
            sb.insert(0, Integer.toString(n % 2));
            n = n / 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            System.out.println(getBinaryNumber(n));
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class I {

    private static boolean isPowerOfFour(int n) {
        // Ваше решение
        boolean result = true;
        while (result) {
            if (n < 4 && n != 1 ) return false;
            if (n==1) return true;
            var remainder = n % 4;
            if (remainder != 0) {
                return false;
            }
            n = n / 4;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            if (isPowerOfFour(n)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}
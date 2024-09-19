package sprint2.K;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {


    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String a = reader.readLine();

            // Разделяем строку по пробелу
            String[] parts = a.split(" ");

            // Преобразуем каждую часть в число
            int number1 = Integer.parseInt(parts[0]);
            int number2 = Integer.parseInt(parts[1]);

            int decimalPowerValue = 1;
            for (int i = 1; i <= number2; i++) {
                decimalPowerValue *= 10;
            }
            System.out.println(fib(number1, decimalPowerValue));
        }

    }

    private static int fib(int fibonacciNum, int decimalPowerValue) {
        if (fibonacciNum == 0 || fibonacciNum == 1) {
            return 1;
        }
        int fibonacciResult = 0;
        int aprev = 1;
        int bprev = 1;
        for (int i = 2; i <= fibonacciNum; i++) {
            fibonacciResult = (aprev + bprev) % decimalPowerValue;
            aprev = bprev;
            bprev = fibonacciResult;
        }
        return fibonacciResult;
    }
}

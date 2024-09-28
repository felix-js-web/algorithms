package sprint3;

public class FactorialTail {

    public static void main(String args[]) {
        System.out.println(factorialTail(10));
    }

    private static int factorialTail(int n) {
        int accumulator = 1;
        return factorialHelp(n, accumulator);
    }

    private static int factorialHelp(int n, int accumulator) {
        if (n == 1) {
            return accumulator;
        }
        return factorialHelp(n - 1, accumulator * n);

    }

}

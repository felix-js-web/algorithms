package sprint3;

public class FactorialTailRecursive {

    public static int factorial(int n) {
        return factorialHelper(n, 1);  // Начинаем с 1 как накопитель результата
    }

    // Вспомогательная функция с хвостовой рекурсией
    private static int factorialHelper(int n, int accumulator) {
        if (n == 1) {
            return accumulator;  // Когда дошли до конца, возвращаем результат
        }
        return factorialHelper(n - 1, n * accumulator);  // Хвостовой рекурсивный вызов
    }

    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println(result);  // Вывод: 120
    }
}

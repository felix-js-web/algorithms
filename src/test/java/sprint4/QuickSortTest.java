package sprint4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static sprint4.QuickSort.quickSortMine;

class QuickSortTest {

    @Test
    void quickSortMineTest() {
        Random random = new Random();

        // Генерируем 1000 тестов
        for (int i = 0; i < 1000; i++) {
            List<Integer> testArray = generateRandomArray(random, 10, 100); // 10 - длина, 100 - максимальный элемент
            List<Integer> sortedArray = quickSortMine(new ArrayList<>(testArray)); // Сортируем с помощью твоего алгоритма
            List<Integer> expectedArray = new ArrayList<>(testArray);
            Collections.sort(expectedArray); // Ожидаемый результат сортировки

            // Проверяем, совпадают ли отсортированные массивы
            if (!sortedArray.equals(expectedArray)) {
                System.out.println("Тест не пройден на входе: " + testArray);
                System.out.println("Ожидается: " + expectedArray);
                System.out.println("Результат: " + sortedArray);
            } else {
                System.out.println("Тест №" + (i + 1) + " пройден");
            }
        }
    }


    // Генерация случайного массива
    private static List<Integer> generateRandomArray(Random random, int length, int maxVal) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            array.add(random.nextInt(maxVal)); // случайное число от 0 до maxVal
        }
        return array;
    }
}
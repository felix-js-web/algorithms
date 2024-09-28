package sprint4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static sprint4.SelectionSort.sortArraySelectionSort;

class SelectionSortTest {

    @Test
    void sortArrayInsertion() {

        Random random = new Random();

        // Генерируем и проверяем 1000 тестов
        for (int test = 0; test < 1000; test++) {
            // Генерация случайного массива длиной от 1 до 1000 с элементами от -1000 до 1000
            int arrayLength = random.nextInt(1000) + 1; // Длина от 1 до 1000
            int[] randomArray = new int[arrayLength];

            for (int i = 0; i < arrayLength; i++) {
                randomArray[i] = random.nextInt(2001) - 1000; // Значения от -1000 до 1000
            }

            // Копируем массив для проверки
            int[] sortedBySelectionSort = Arrays.copyOf(randomArray, randomArray.length);
            int[] sortedByJavaSort = Arrays.copyOf(randomArray, randomArray.length);

            // Сортируем массивы
            sortedBySelectionSort = sortArraySelectionSort(sortedBySelectionSort);
            Arrays.sort(sortedByJavaSort);

            // Проверяем, что результат сортировки совпадает с Arrays.sort()
            if (!Arrays.equals(sortedBySelectionSort, sortedByJavaSort)) {
                System.out.println("Ошибка на тесте №" + test);
                System.out.println("Оригинальный массив: " + Arrays.toString(randomArray));
                System.out.println("Сортировка выбором: " + Arrays.toString(sortedBySelectionSort));
                System.out.println("Ожидаемый результат: " + Arrays.toString(sortedByJavaSort));
                return;
            }
        }

        System.out.println("Все 1000 тестов успешно пройдены!");


    }
}
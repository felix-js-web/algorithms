package sprint4;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class SortByKey {

    public static int[] digit_lengths = {4, 4, 3, 3, 6, 4, 5, 4, 6, 6}; // длины слов «ноль», «один»,...

    public static void  main(String args[]){

        int[] cards = {3, 7, 9, 2, 3};
        Arrays.stream(cards).forEach(value -> System.out.println(value));
        // Передаем ключ сравнения с использованием card_strength
        IntUnaryOperator sortKey = card -> card_strength(card);

        insertion_sort_by_key(cards, sortKey);
        Arrays.stream(cards).forEach(value -> System.out.println(value));
    }


    public static int card_strength(int card) { // ключ сравнения
        return digit_lengths[card];
    }

    // воспользуемся уже знакомой сортировкой вставками
    public static void insertion_sort_by_key(int[] array, IntUnaryOperator key) {
        for (int i = 1; i < array.length; i++) {
            int item_to_insert = array[i];
            int j = i;
            // заменим сравнение item_to_insert < array[j-1] на сравнение ключей
            while (j > 0 && key.applyAsInt(item_to_insert) < key.applyAsInt(array[j - 1])) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = item_to_insert;
        }
    }
}

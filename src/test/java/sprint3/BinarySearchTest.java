package sprint3;


import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private static final int TEST_CASES = 1000;
    private static final int ARRAY_SIZE = 100;
    private static final int MAX_VALUE = 1000;

    @Test
    void binarySearch() {
        Random random = new Random();
        for (int i = 0; i < TEST_CASES; i++) {
            int[] sortedArray = generateSortedArray(ARRAY_SIZE, MAX_VALUE, random);
            int soughtNumber = random.nextInt(MAX_VALUE);
            int expectedIndex = Arrays.binarySearch(sortedArray, soughtNumber);
            if (expectedIndex < 0) {
                expectedIndex = -1;
            }
            int actualIndex = BinarySearch.binarySearch(sortedArray, soughtNumber, 0, sortedArray.length);
            assertEquals(expectedIndex, actualIndex, "Test case " + i + " failed");
        }
    }

    private int[] generateSortedArray(int size, int maxValue, Random random) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue);
        }
        Arrays.sort(array);
        return array;
    }
}
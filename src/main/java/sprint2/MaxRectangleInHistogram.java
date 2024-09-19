package sprint2;


import java.util.Stack;

public class MaxRectangleInHistogram {
    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3}; // Наш массив высот столбцов
        int[] heights = {2}; // Наш массив высот столбцов
        System.out.println("Максимальная площадь прямоугольника: " + getMaxRectangleArea(heights));
    }

    public static int getMaxRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // Стек для хранения индексов столбиков
        int maxArea = 0; // Здесь будет храниться максимальная площадь
        int i = 0;

        // Проходим по всем столбцам
        while (i < heights.length) {
            // Если текущий столбик выше или равен предыдущему, кладем его в стек
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                // Если текущий столбик ниже, вычисляем площадь для предыдущего столбика
                int height = heights[stack.pop()]; // Достаем индекс из стека и получаем высоту
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Ширина прямоугольника
                maxArea = Math.max(maxArea, height * width); // Считаем площадь и обновляем максимальную
            }
        }

        // Обрабатываем оставшиеся элементы в стеке
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}

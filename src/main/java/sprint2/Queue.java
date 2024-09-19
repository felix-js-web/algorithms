package sprint2;

public class Queue {

    private Integer[] queue;
    private int head;
    private int tail;
    private int max_n;
    private int size;

    public Queue(int n) {
        queue = new Integer[n];
        head = 0;
        tail = 0;
        max_n = n;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int x) {
        if (size != max_n) {
            queue[tail] = x;
            tail = (tail + 1) % max_n;
            size++;
        }
    }


    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        Integer x = queue[head];
        queue[head] = null;
        head = (head + 1) % max_n;
        size--;
        return x;
    }

    public static void main(String args[]) {
        Queue q = new Queue(8);

        q.push(1);
        q.printQueue();  // [1, None, None, None, None, None, None, None]
        System.out.println(q.size);  // 1

        q.push(-1);
        q.push(0);
        q.push(11);
        q.printQueue();  // [1, -1, 0, 11, None, None, None, None]
        System.out.println(q.size);  // 4

        q.pop();
        q.printQueue();  // [None, -1, 0, 11, None, None, None, None]
        System.out.println(q.size);  // 3

        q.pop();
        q.pop();
        q.push(-8);
        q.push(7);
        q.push(3);
        q.push(16);
        q.printQueue(); // [None, None, None, 11, -8, 7, 3, 16]
        System.out.println(q.size); // 5

        q.push(12);
        q.push(12);
        q.push(12);
        q.push(12);
        q.push(12);
        q.push(12);
        q.push(12);
        q.printQueue(); // [12, None, None, 11, -8, 7, 3, 16]
        System.out.println(q.size); // 6
    }

    public void printQueue() {
        System.out.print("[");
        for (int i = 0; i < max_n; i++) {
            if (queue[i] == null) {
                System.out.print("None");
            } else {
                System.out.print(queue[i]);
            }
            if (i != max_n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }


}

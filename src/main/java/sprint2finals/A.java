//Principles of work
//1) I Used as suggest Array Structure underneath the ring buffer structure
// with head and tail to control the queue sizes and head and tail positions
// and Value fields in the Integer Array.
//2) Pop and Push do work on head and tail and size variables accordingly
//taking into account the size of the deque

//Correctness
//1) I do believe thats the correct structure to be used
//which is kidna non internal to collections - we could use also LinkedList
// with Prev and Next though
//2) Current algorithm is correct because
//2.a) It backs the correctness by the array of size equals to queue size
//2.b) Plus proper head and tail numbering provided including
// those able to overflow the borders but in ring style
//
// Time Complexity
// because we dont deal with travelling through the dequeue and
// only dealing with front and end - which are objects
// we are keeping in memory our head and tail numbers
// so all those operations are O(1) which is constant time
//Space Complexity   O(n) where n is size of the deque
// Because we are creating N objects maximum which is maximum length of the queue Array.

//https://contest.yandex.ru/contest/22781/run-report/118358031/
package sprint2finals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RingBuffer {

    private int size = 0;
    private int head = -1;
    private int tail = -1;
    private final int deqLength;
    private final Integer[] intArray;

    public RingBuffer(int n) {
        this.deqLength = n;
        intArray = new Integer[deqLength];
    }

    // checked Deque interface in oracle Doco
    // add first and add last are void  followed that
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Deque.html#addFirst(E)
    // similarly for pop thanks for comment
    public void pushBack(int value) {
        if (isEmpty()) {
            intArray[0] = value;
            head = 0;
            tail = 0;
            size++;
        } else if (isFull()) {
            throw new IllegalStateException("Queue is FULL push can not happen");
        } else {
            tail = (tail + 1 + deqLength) % deqLength;
            intArray[tail] = value;
            size++;
        }
    }

    public void pushFront(int value) {
        if (isEmpty()) {
            intArray[0] = value;
            head = 0;
            tail = 0;
            size++;
        } else if (isFull()) {
            throw new IllegalStateException("Queue is FULL push can not happen");
        } else {
            head = (head - 1 + deqLength) % deqLength;
            intArray[head] = value;
            size++;
        }
    }

    public Integer popFront() {
        Integer poppedNumber;
        if (isEmpty()) {
            throw new IllegalStateException("Queue is EMPTY pop can not happen");
        } else if (tail == head && size == 1) {
            poppedNumber = intArray[head];
            intArray[head] = null;
            head = -1;
            tail = -1;
            size--;
        } else {
            poppedNumber = intArray[head];
            intArray[head] = null;
            head = (head + 1 + deqLength) % deqLength;
            size--;
        }
        return poppedNumber;
    }

    public Integer popBack() {
        Integer poppedNumber;
        if (isEmpty()) {
            throw new IllegalStateException("Queue is EMPTY pop can not happen");
        } else if (tail == head && size == 1) {
            poppedNumber = intArray[tail];
            intArray[tail] = null;
            head = -1;
            tail = -1;
            size--;
        } else {
            poppedNumber = intArray[tail];
            intArray[tail] = null;
            tail = (tail - 1 + deqLength) % deqLength;
            size--;
        }
        return poppedNumber;
    }

    private boolean isEmpty() {
        return size <= 0;
    }

    private boolean isFull() {
        return size == deqLength;
    }

}


public class A {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCommands = Integer.parseInt(reader.readLine());
            int deckLength = Integer.parseInt(reader.readLine());
            String[] actionsStrings = new String[numberOfCommands];
            for (int i = 0; i < numberOfCommands; i++) {
                actionsStrings[i] = reader.readLine();
            }
            commandRunner(numberOfCommands, deckLength, actionsStrings);
        }
    }

    private static void commandRunner(int numberOfCommands, int deckLength, String[] commandsArray) {
        RingBuffer ringBuffer = new RingBuffer(deckLength);
        for (int i = 0; i < commandsArray.length; i++) {
            String action = commandsArray[i];
            try {
                switch (action.split(" ")[0]) {
                    case "pop_front":
                        System.out.println(ringBuffer.popFront());
                        break;
                    case "pop_back":
                        System.out.println(ringBuffer.popBack());
                        break;
                    case "push_back":
                        ringBuffer.pushBack(Integer.valueOf(action.replace("push_back ", "")));
                        break;
                    case "push_front":
                        ringBuffer.pushFront(Integer.valueOf(action.replace("push_front ", "")));
                        break;
                    default:
                        throw new RuntimeException("This command not been requested - invalid task");
                }
            } catch (IllegalStateException e) {
                System.out.println("error");
            }
        }
    }
}
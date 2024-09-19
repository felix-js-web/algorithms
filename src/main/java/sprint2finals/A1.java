//Principles of work
//1) I Used LinkedList structure with Next and Prev nodes and Value field.
//2) Pop and Push do work on next and prevs accordingly
//taking into account the size of the deq
//3) For debugging purposes print queue and others added in the main
//
//Correctness
//1) I do believe thats the only correct structure to be used
//which is kidna non internal to collections - we could use also arraylist though
//
//Time Complexity
// because we dont deal with travelling through the dequeue and
// only dealing with front and end - which are objects we are keeping in memory
// so all those operations are O(1) which is constant time
//Space Complexity   O(n) where n is size of the deque
// Because we are creating N objects maximum which is maximum length of the queue.
// ????????????
// here I have the problem as of I was promised that every sprint
// webinar with my group to discuss our questions
// - and I mostly have questions on space complexity and time
// complexity and no one to discuss them with
// I did raise it with my KURATOR already
// - she promised the webinar going to happen - but still no news
// Thats a very very frustrating experience that I have to complain about it
// It is a very bad sigh too - after doing so much - letting things down just in one small thing.
// I am not sure if you can help me with that?
// but yes that part is very frustrating - if I been promised why I have to raise it?
// Apologies for the complaint
// ??????????

//https://contest.yandex.ru/contest/22781/run-report/117966999/
package sprint2finals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RingBuffer {

//    private final int deckLength;
//    private int tail = 0;
//
//    private LinkedList firstElement;
//    private LinkedList lastElement;

    private Integer[] queue;
    private int head;
    private int tail;
    private int max_n;
    private int size;

    public RingBuffer(int deckLength) {
        queue = new Integer[deckLength];
        head = 0;
        tail = 0;
        max_n = deckLength;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void pushBack(int x) {
        if (size < max_n) {
            queue[tail] = x;
            tail = (tail + 1) % max_n;
            size++;
        } else {
            System.out.println("error");
        }
    }


    public void pushFront(int x) {
        if (size < max_n) {
            queue[head] = x;
            tail = (tail + 1) % max_n;
            size++;
        } else {
            System.out.println("error");
        }
    }

    public Integer popFront() {
        if (isEmpty()) {
            System.out.println("error");
        }
        Integer x = queue[head];
        queue[head] = null;
        head = (head + 1) % max_n;
        size--;
        return x;
    }

    public Integer popBack() {
        if (isEmpty()) {
            System.out.println("error");
        }
        Integer x = queue[tail - 1];
        queue[tail - 1] = null;
        tail = (tail - 1) % max_n;
        size--;
        return x;
    }

    public void pushBack2(int v) {
//        if (lastElement == null) {
//            lastElement = new LinkedList(v, null, null);
//            if (firstElement == null) {
//                firstElement = lastElement;
//                tail++;
//            } else {
//                throw new RuntimeException("HOW DID THIS HAPPEN?");
//            }
//        } else if (tail < deckLength) {
//            LinkedList newLast = new LinkedList(v, lastElement, null);
//            lastElement.setNext(newLast);
//            lastElement = newLast;
//            tail++;
//        } else {
//            System.out.println("error");
//        }
    }

    public void pushFront(int v) {
//        if (firstElement == null) {
//            firstElement = new LinkedList(v, null, null);
//            if (lastElement == null) {
//                lastElement = firstElement;
//                tail++;
//            } else {
//                throw new RuntimeException("HOW DID THIS HAPPEN?");
//            }
//        } else if (tail < deckLength) {
//            LinkedList newFirst = new LinkedList(v, null, firstElement);
//            firstElement.setPrev(newFirst);
//            firstElement = newFirst;
//            tail++;
//        } else {
//            System.out.println("error");
//        }
    }

    public void popBack2() {
//        if (lastElement != null) {
//            System.out.println(lastElement.getValue());
//            tail--;
//            if (lastElement != firstElement) {
//                lastElement = lastElement.getPrev();
//                lastElement.setNext(null);
//            } else {
//                // queue is empty again
//                lastElement = null;
//                firstElement = null;
//            }
//        } else {
//            System.out.println("error");
//        }
    }

    public void popFront2() {
//        if (firstElement != null) {
//            System.out.println(firstElement.getValue());
//            tail--;
//            if (firstElement != lastElement) {
//                firstElement = firstElement.getNext();
//                firstElement.setPrev(null);
//            } else {
//                // queue is empty again
//                lastElement = null;
//                firstElement = null;
//            }
//        } else {
//            System.out.println("error");
//        }
    }

    public void printQueue() {
//        System.out.println("tail is " + tail);
//        LinkedList startElement = firstElement;
//        System.out.println(" QUEUE IS ");
//        while (startElement != null) {
//            System.out.print(startElement.getValue() + "  ");
//            startElement = startElement.getNext();
//        }
//        System.out.println("  ");
    }
}
//
//class LinkedList {
//    private int value;
//    private LinkedList prev;
//    private LinkedList next;
//
//    public LinkedList(int value, LinkedList prev, LinkedList next) {
//        this.value = value;
//        this.prev = prev;
//        this.next = next;
//    }
//
//    public LinkedList getNext() {
//        return next;
//    }
//
//    public void setNext(LinkedList next) {
//        this.next = next;
//    }
//
//    public LinkedList getPrev() {
//        return prev;
//    }
//
//    public void setPrev(LinkedList prev) {
//        this.prev = prev;
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//}

public class A1 {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCommands = Integer.parseInt(reader.readLine());
            int deckLength = Integer.parseInt(reader.readLine());
            RingBuffer ringBuffer = new RingBuffer(deckLength);

            String[] actionsStrings = new String[numberOfCommands];
            for (int i = 0; i < numberOfCommands; i++) {
                actionsStrings[i] = reader.readLine();
            }

//            String input = "push_front 842\n" +
//                    "pop_back\n" +
//                    "push_back 908\n" +
//                    "push_front 115";
//            String[] actionsStrings = input.split("\n");
            for (int i = 0; i < actionsStrings.length; i++) {

                String action = actionsStrings[i];
//                ringBuffer.printQueue();
//                System.out.println("next action is " + action);
                if (action.startsWith("pop_front")) {
                    ringBuffer.popFront();
                }

                if (action.startsWith("pop_back")) {
                    ringBuffer.popBack();
                }

                if (action.startsWith("push_back")) {
                    ringBuffer.pushBack(Integer.valueOf(action.replace("push_back ", "")));
                }

                if (action.startsWith("push_front")) {
                    ringBuffer.pushFront(Integer.valueOf(action.replace("push_front ", "")));
                }
            }
        }
    }
}
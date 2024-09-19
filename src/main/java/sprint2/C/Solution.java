package sprint2.C;

// <template>
class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}
// <template>

public class Solution {
    public static Node<String> solution(Node<String> head, int idx) {
        // Your code
        // ヽ(´▽`)/
        if (idx == 0) {
            return head.next;
        } else {
            Node<String> startNode = head;
            Node<String> previousNode = null;
            while (idx > 0 && (startNode != null || startNode.next != null)) {
                previousNode = startNode;
                startNode = startNode.next;
                idx--;
            }
            previousNode.next = startNode.next;

        }
        return head;
    }

    public static void main(String args[]) {
        test();
    }

    private static void test() {
        Node<String> node15 = new Node<>("node3", null);
        Node<String> node14 = new Node<>("node2", node15);
        Node<String> node13 = new Node<>("node1", node14);
        Node<String> node12 = new Node<>("node0", node13);
        Node<String> node11 = new Node<>("node3", node12);
        Node<String> node10 = new Node<>("node2", node11);
        Node<String> node9 = new Node<>("node1", node10);
        Node<String> node8 = new Node<>("node0", node9);
        Node<String> node7 = new Node<>("node3", node8);
        Node<String> node6 = new Node<>("node2", node7);
        Node<String> node5 = new Node<>("node1", node6);
        Node<String> node4 = new Node<>("node0", node5);
        Node<String> node3 = new Node<>("node3", node4);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        Node<String> newHead = solution(node0, 11);
        assert newHead == node0;
//        assert newHead.next == node2;
//        assert newHead.next.next == node3;
//        assert newHead.next.next.next == null;
        // result is : node0 -> node2 -> node3
    }
}
package sprint2;

class LinkedNode<V> {
    public V value;
    public LinkedNode<V> next;

    public LinkedNode(V value, LinkedNode<V> next) {
        this.value = value;
        this.next = next;
    }


}

public class B {

    public static void main(String[] args) {
        LinkedNode<String> tail = new LinkedNode<>("tail", null);
        LinkedNode<String> head3 = new LinkedNode<>("head3", tail);
        LinkedNode<String> head2 = new LinkedNode<>("head2", head3);
        LinkedNode<String> head1 = new LinkedNode<>("head1", head2);

        var printLinkedNode = head1;
        while (printLinkedNode != null) {
            System.out.println(printLinkedNode.value);
            printLinkedNode = printLinkedNode.next;
        }


        LinkedNode<String> node3 = new LinkedNode<>("node3", null);
        LinkedNode<String> node2 = new LinkedNode<>("node2", node3);
        LinkedNode<String> node1 = new LinkedNode<>("node1", node2);
        LinkedNode<String> node0 = new LinkedNode<>("node0", node1);

        var printLinkedNode3 = node0;
        while (printLinkedNode3 != null) {
            System.out.println(printLinkedNode3.value);
            printLinkedNode3 = printLinkedNode3.next;
        }

        LinkedNode<String> newHead = solution(node0, 1);

        assert newHead == node0;
        assert newHead.next == node2;
        assert newHead.next.next == node3;
        assert newHead.next.next.next == null;

        var printLinkedNode2 = node0;
        while (printLinkedNode2 != null) {
            System.out.println(printLinkedNode2.value);
            printLinkedNode2 = printLinkedNode2.next;
        }

        // result is : node0 -> node2 -> node3

    }

    private static LinkedNode<String> solution(LinkedNode<String> node0, int i) {
        if (i == 0) {
            return node0.next;
        } else {
            LinkedNode<String> startNode = node0;
            LinkedNode<String> previousNode = null;
            while ((i > 0) && (startNode != null || startNode.next != null)) {
                previousNode = startNode;
                startNode = startNode.next;
                i--;
            }
            previousNode.next = startNode.next;

        }
        return node0;
    }

}
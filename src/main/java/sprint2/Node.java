package sprint2;

public class Node {
    public String value;
    public Node next;

    public Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(String value) {
        this(value, null);
    }
}

class Main {
    static void printLinkedList(Node vertex) {
        while (vertex != null) {
            System.out.print(vertex.value + " -> ");
            vertex = vertex.next;
        }
        System.out.println("None");
    }

    public static Node getNodeByIndex(Node node, int index) {
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    public static Node insertNode(Node head, int index, String value) {
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            return newNode;
        }
        Node previousNode = getNodeByIndex(head, index-1);
        newNode.next = previousNode.next;
        previousNode.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        Node n3 = new Node("third");
        Node n2 = new Node("second", n3);
        Node n1 = new Node("first", n2);
        printLinkedList(n1);
        printLinkedList(n2);

        Node node = n1;
        int index = 2;
        String value = "new_node";
        Node head = insertNode(node, index, value);
        printLinkedList(head);
    }
}
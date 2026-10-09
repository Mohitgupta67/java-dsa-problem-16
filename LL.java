import java.util.*;

class LL {

    Node head;
    private int size;

    LL() {
        this.size = 0;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // Add First
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Add Last
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;

        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    // Print List
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("NULL");
    }

    // Delete First
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        size--;
        head = head.next;
    }

    // Delete Last
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        size--;

        if (head.next == null) {
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

        secondLast.next = null;
    }

    // Get Size
    public int getSize() {
        return size;
    }

    // Reverse Iterative
    public void reverseIterate() {
        if (head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;

        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;
    }

    // Reverse Recursive
    public Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String args[]) {
        LL list = new LL();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.printList();

        list.reverseIterate();

        list.printList();
    }
}
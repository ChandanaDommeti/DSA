import java.util.ArrayList;

public class Main {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class circularLinkedList {
        Node last;

        CircularLinkedList() {
            this.last = null;
        }

        void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            if (last == null) {
                last = newNode;
                last.next = last;
            } else {
                newNode.next = last.next;
                last.next = newNode;
            }
        }

        void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (last == null) {
                last = newNode;
                last.next = last;
            } else {
                newNode.next = last.next;
                last.next = newNode;
                last = newNode;
            }
        }

        void insertAfter(int data, int item) {
            if (last == null) return;
            Node temp = last.next;
            do {
                if (temp.data == item) {
                    Node newNode = new Node(data);
                    newNode.next = temp.next;
                    temp.next = newNode;
                    if (temp == last) last = newNode;
                    return;
                }
                temp = temp.next;
            } while (temp != last.next);
        }

        void deleteAtBeginning() {
            if (last == null) return;
            if (last.next == last) {
                last = null;
            } else {
                last.next = last.next.next;
            }
        }

        void deleteAtEnd() {
            if (last == null) return;
            if (last.next == last) {
                last = null;
            } else {
                Node temp = last.next;
                while (temp.next != last) {
                    temp = temp.next;
                }
                temp.next = last.next;
                last = temp;
            }
        }

        void deleteNode(int key) {
            if (last == null) return;
            if (last.data == key && last.next == last) {
                last = null;
                return;
            }
            Node temp = last.next, prev = last;
            do {
                if (temp.data == key) {
                    prev.next = temp.next;
                    if (temp == last) last = prev;
                    return;
                }
                prev = temp;
                temp = temp.next;
            } while (temp != last.next);
        }

        void traverse() {
            if (last == null) return;
            Node temp = last.next;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != last.next);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtEnd(30);
        list.insertAfter(25, 20);
        list.traverse();
        list.deleteAtBeginning();
        list.traverse();
        list.deleteAtEnd();
        list.traverse();
        list.deleteNode(25);
        list.traverse();
    }
}

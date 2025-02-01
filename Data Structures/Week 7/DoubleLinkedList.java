public class Main {
    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static class DoubleLinkedList {
        Node head;

        void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            if (head != null) {
                newNode.next = head;
                head.prev = newNode;
            }
            head = newNode;
        }

        void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }

        void insertAfter(int data, int key) {
            Node temp = head;
            while (temp != null && temp.data != key) {
                temp = temp.next;
            }
            if (temp == null) return;
            Node newNode = new Node(data);
            newNode.next = temp.next;
            newNode.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            temp.next = newNode;
        }

        void deleteAtBeginning() {
            if (head == null) return;
            if (head.next != null) {
                head.next.prev = null;
            }
            head = head.next;
        }

        void deleteAtEnd() {
            if (head == null) return;
            if (head.next == null) {
                head = null;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
        }

        void deleteNode(int key) {
            Node temp = head;
            while (temp != null && temp.data != key) {
                temp = temp.next;
            }
            if (temp == null) return;
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            } else {
                head = temp.next;
            }
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        }

        void traverse() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
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

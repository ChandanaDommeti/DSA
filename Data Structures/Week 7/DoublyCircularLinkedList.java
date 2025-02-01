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

    static class DoublyCircularLinkedList {
        Node head;

        void append(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                head.next = head;
                head.prev = head;
                return;
            }
            Node last = head.prev;
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }

        void traverse() {
            if (head == null) return;
            Node temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }

    static Node mergeSortedLists(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node last1 = head1.prev;
        Node last2 = head2.prev;

        last1.next = null;
        last2.next = null;
        head1.prev = null;
        head2.prev = null;

        Node mergedHead = mergeTwoLists(head1, head2);

        Node lastNode = mergedHead;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        mergedHead.prev = lastNode;
        lastNode.next = mergedHead;

        return mergedHead;
    }

    static Node mergeTwoLists(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node result;
        if (head1.data < head2.data) {
            result = head1;
            result.next = mergeTwoLists(head1.next, head2);
            if (result.next != null) result.next.prev = result;
        } else {
            result = head2;
            result.next = mergeTwoLists(head1, head2.next);
            if (result.next != null) result.next.prev = result;
        }
        return result;
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList list1 = new DoublyCircularLinkedList();
        DoublyCircularLinkedList list2 = new DoublyCircularLinkedList();

        list1.append(1);
        list1.append(3);
        list1.append(5);

        list2.append(2);
        list2.append(4);
        list2.append(6);

        Node mergedHead = mergeSortedLists(list1.head, list2.head);

        DoublyCircularLinkedList mergedList = new DoublyCircularLinkedList();
        mergedList.head = mergedHead;
        mergedList.traverse();
    }
}

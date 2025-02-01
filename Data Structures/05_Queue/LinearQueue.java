import java.util.Scanner;

public class LinearQueue {
    static final int MAX = 100;
    static int[] queue = new int[MAX];
    static int front = 0, rear = 0;

    public static boolean isEmpty() {
        return front == rear;
    }

    public static boolean isFull() {
        return rear == MAX;
    }

    public static void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            queue[rear++] = item;
        }
    }

    public static void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Dequeued: " + queue[front++]);
        }
    }

    public static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (int i = front; i < rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Enqueue 2. Dequeue 3. Display 4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter item: ");
                    int item = sc.nextInt();
                    enqueue(item);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

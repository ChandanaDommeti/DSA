class CircularQueue {
    private int size;
    private int front, rear;
    private int[] queue;

    public CircularQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = this.rear = -1;
    }

    public void enqueue(int data) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            queue[rear] = data;
        }
    }

    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int data = queue[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return data;
        }
    }

    public void display() {
        if (front == -1) {
            System.out.println("Queue is empty");
        } else {
            int i = front;
            while (true) {
                System.out.print(queue[i] + " ");
                if (i == rear) break;
                i = (i + 1) % size;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.display();
        System.out.println(queue.dequeue());
        queue.display();
        queue.enqueue(50);
        queue.enqueue(60);
        queue.display();
    }
}

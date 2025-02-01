import java.util.ArrayDeque;
import java.util.Deque;

public class DequeOperations {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addLast(10);
        deque.addLast(20);
        deque.addFirst(5);
        System.out.println("Deque: " + deque);

        System.out.println("Front element: " + deque.peekFirst());
        System.out.println("Last element: " + deque.peekLast());

        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque after removals: " + deque);

        deque.addLast(30);
        deque.addLast(40);
        deque.addLast(50);
        deque.addFirst(15);
        System.out.println("Updated deque: " + deque);

        deque.remove(30);
        System.out.println("Deque after removing 30: " + deque);

        System.out.println("Size of deque: " + deque.size());
        System.out.println("Contains 40: " + deque.contains(40));

        deque.clear();
        System.out.println("Deque after clear: " + deque);
    }
}

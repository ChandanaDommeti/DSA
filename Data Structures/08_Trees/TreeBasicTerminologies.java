import java.util.ArrayList;
import java.util.List;

public class TreeBasicTerminologies {
    
    static void printChildren(int root, List<List<Integer>> adj) {
        if (root >= adj.size()) {
            System.out.println("Invalid root");
            return;
        }
        System.out.print("Children of node " + root + ": ");
        for (int child : adj.get(root)) {
            System.out.print(child + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            adj.add(new ArrayList<>());
        }
        
        adj.get(0).add(1); // Root node 0 has child 1
        adj.get(0).add(2); // Root node 0 has child 2
        adj.get(1).add(3); // Node 1 has child 3
        adj.get(1).add(4); // Node 1 has child 4
        adj.get(2).add(5); // Node 2 has child 5
        adj.get(2).add(6); // Node 2 has child 6

        printChildren(0, adj);
        printChildren(1, adj);
        printChildren(2, adj);
    }
}

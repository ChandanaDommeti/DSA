import java.util.*;

class BestFirstSearch {
    static int v = 14;
    static List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();

    static class Pair<K, V> {
        K key;
        V value;
        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    static void addedge(int x, int y, int cost) {
        graph.get(x).add(new Pair<>(y, cost));
        graph.get(y).add(new Pair<>(x, cost));
    }

    static void best_first_search(int actual_Src, int target, int n) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        boolean[] visited = new boolean[n];
        pq.add(new Pair<>(actual_Src, 0));

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> node = pq.poll();
            int u = node.key;

            if (u == target) {
                System.out.println("Goal " + target + " found");
                return;
            }

            visited[u] = true;

            for (Pair<Integer, Integer> neighbor : graph.get(u)) {
                int v = neighbor.key;
                int cost = neighbor.value;
                if (!visited[v]) {
                    pq.add(new Pair<>(v, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges to the graph
        addedge(0, 1, 2);
        addedge(0, 2, 1);
        addedge(1, 3, 5);
        addedge(1, 4, 3);
        addedge(2, 5, 2);
        addedge(3, 6, 4);
        addedge(4, 7, 6);
        addedge(5, 8, 1);
        addedge(6, 9, 2);
        addedge(7, 10, 7);
        addedge(8, 11, 5);
        addedge(9, 12, 3);
        addedge(10, 13, 4);

        // Run Best First Search starting from source node 0 to goal node 13
        best_first_search(0, 13, v);
    }
}

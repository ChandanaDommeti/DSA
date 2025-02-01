import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GraphDFS {
    private Map<Integer, List<Integer>> graph;

    public GraphDFS() {
        graph = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(v);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        
        for (int neighbor : graph.getOrDefault(v, new ArrayList<>())) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public void DFS() {
        boolean[] visited = new boolean[graph.size()];
        
        for (int node : graph.keySet()) {
            if (!visited[node]) {
                DFSUtil(node, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        System.out.print("DFS Traversal: ");
        g.DFS();
    }
}

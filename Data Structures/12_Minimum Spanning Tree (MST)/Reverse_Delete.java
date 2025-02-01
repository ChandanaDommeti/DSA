import java.util.*;

public class Reverse_Delete {
    private int V;
    private List<Edge> edges;

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return compareEdge.weight - this.weight;
        }
    }

    public Graph(int V) {
        this.V = V;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge();
        edge.src = src;
        edge.dest = dest;
        edge.weight = weight;
        edges.add(edge);
    }

    private boolean isConnectedAfterRemoval(int excludeSrc, int excludeDest) {
        boolean[] visited = new boolean[V];
        dfs(0, visited, excludeSrc, excludeDest);
        for (boolean visit : visited) {
            if (!visit) return false;
        }
        return true;
    }

    private void dfs(int v, boolean[] visited, int excludeSrc, int excludeDest) {
        visited[v] = true;
        for (Edge edge : edges) {
            if ((edge.src == excludeSrc && edge.dest == excludeDest) || 
                (edge.src == excludeDest && edge.dest == excludeSrc)) {
                continue;
            }
            if (edge.src == v && !visited[edge.dest]) {
                dfs(edge.dest, visited, excludeSrc, excludeDest);
            } else if (edge.dest == v && !visited[edge.src]) {
                dfs(edge.src, visited, excludeSrc, excludeDest);
            }
        }
    }

    public void reverseDeleteMST() {
        edges.sort(null);
        List<Edge> mstEdges = new ArrayList<>(edges);

        for (Edge edge : edges) {
            mstEdges.remove(edge);
            if (!isConnectedAfterRemoval(edge.src, edge.dest)) {
                mstEdges.add(edge);
            }
        }

        System.out.println("Edges in Minimum Spanning Tree:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.src + " - " + edge.dest + ": " + edge.weight);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 3, 10);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 1);

        graph.reverseDeleteMST();
    }
}

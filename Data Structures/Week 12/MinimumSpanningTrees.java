import java.util.*;

public class MinimumSpanningTrees {
    class Edge implements Comparable<Edge> {
        int src, dest;
        double weight;

        public int compareTo(Edge compareEdge) {
            return Double.compare(this.weight, compareEdge.weight);
        }
    }

    class Subset {
        int parent, rank;
    }

    private int V, E;
    private Edge[] edges;

    public MinimumSpanningTrees(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
        }
    }

    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    private void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public double minimumProductSpanningTree() {
        for (Edge edge : edges) {
            edge.weight = Math.log(edge.weight);
        }
        Arrays.sort(edges);
        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        double product = 0;
        int count = 0;
        for (Edge edge : edges) {
            if (count == V - 1) break;
            int x = find(subsets, edge.src);
            int y = find(subsets, edge.dest);
            if (x != y) {
                product += edge.weight;
                union(subsets, x, y);
                count++;
            }
        }
        return Math.exp(product);
    }

    public static void main(String[] args) {
        int V = 5, E = 6;
        MinimumSpanningTrees graph = new MinimumSpanningTrees(V, E);
        graph.edges[0].src = 0; graph.edges[0].dest = 1; graph.edges[0].weight = 2;
        graph.edges[1].src = 1; graph.edges[1].dest = 2; graph.edges[1].weight = 3;
        graph.edges[2].src = 0; graph.edges[2].dest = 3; graph.edges[2].weight = 4;
        graph.edges[3].src = 1; graph.edges[3].dest = 4; graph.edges[3].weight = 5;
        graph.edges[4].src = 3; graph.edges[4].dest = 4; graph.edges[4].weight = 6;
        graph.edges[5].src = 2; graph.edges[5].dest = 4; graph.edges[5].weight = 7;
        System.out.println("Minimum Product: " + graph.minimumProductSpanningTree());
    }
}

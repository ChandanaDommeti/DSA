import java.util.*;

public class Krushkal {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class Subset {
        int parent, rank;
    }

    int V, E;
    Edge[] edges;

    public Graph(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[e];
    }

    public void addEdge(int eIndex, int src, int dest, int weight) {
        edges[eIndex] = new Edge(src, dest, weight);
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y) {
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

    void kruskalMST() {
        Edge[] result = new Edge[V - 1]; // Store the MST
        int e = 0; // Count of edges in MST
        int i = 0; // Initial index of sorted edges
        Subset[] subsets = new Subset[V];

        for (int v = 0; v < V; ++v) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        // Step 1: Sort all the edges in non-decreasing order of their weight
        Arrays.sort(edges);

        // Step 2: Pick the smallest edge and check for cycle
        while (e < V - 1) {
            Edge nextEdge = edges[i++];
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            // If including this edge does not cause a cycle, include it in the result
            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree:");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree: " + minimumCost);
    }

    public static void main(String[] args) {
        int V = 9; // Number of vertices
        int

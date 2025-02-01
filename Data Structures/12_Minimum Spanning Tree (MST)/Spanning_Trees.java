import java.util.*;

public class Spanning_Trees {
    private int[][] adjMatrix;
    private int V;

    public Graph(int V) {
        this.V = V;
        this.adjMatrix = new int[V][V];
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    private int[][] getLaplacianMatrix() {
        int[][] laplacian = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    laplacian[i][j] = Arrays.stream(adjMatrix[i]).sum();
                } else {
                    laplacian[i][j] = adjMatrix[i][j] == 1 ? -1 : 0;
                }
            }
        }
        return laplacian;
    }

    private int[][] getReducedMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] reduced = new int[n - 1][n - 1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                reduced[i - 1][j - 1] = matrix[i][j];
            }
        }
        return reduced;
    }

    private int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        int determinant = 0;
        for (int col = 0; col < n; col++) {
            int[][] subMatrix = new int[n - 1][n - 1];
            for (int i = 1; i < n; i++) {
                int subCol = 0;
                for (int j = 0; j < n; j++) {
                    if (j == col) continue;
                    subMatrix[i - 1][subCol++] = matrix[i][j];
                }
            }
            determinant += matrix[0][col] * calculateDeterminant(subMatrix) * (col % 2 == 0 ? 1 : -1);
        }
        return determinant;
    }

    public int countSpanningTrees() {
        int[][] laplacian = getLaplacianMatrix();
        int[][] reducedMatrix = getReducedMatrix(laplacian);
        return calculateDeterminant(reducedMatrix);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        System.out.println("Number of Spanning Trees: " + graph.countSpanningTrees());
    }
}

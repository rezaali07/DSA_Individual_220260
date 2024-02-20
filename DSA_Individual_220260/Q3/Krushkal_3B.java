package Q3;

// Implement Kruskal algorithm and priority queue using minimum heap

// Time Complexity: O(E log E) where E is the number of edges 
// Space Complexity: O(V + E) where V means the number of vertices or nodes and E is number of Edges
import java.util.PriorityQueue;

public class Krushkal_3B {

    // Inner class representing an edge in the graph
    public static class Edge implements Comparable<Edge> {
        int s; // source vertex
        int d; // destination vertex
        int w; // weight of the edge

        // Constructor to initialize the edge
        Edge(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }

        // Comparison method to compare edges based on their weights
        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    int v; // number of vertices
    PriorityQueue<Edge> pq; // priority queue to store edges sorted by weight

    // Constructor to initialize the number of vertices and priority queue
    Krushkal_3B(int v) {
        this.v = v;
        this.pq = new PriorityQueue<>();
    }

    // Method to add an edge to the graph
    void addEdge(int s, int d, int w) {
        pq.add(new Edge(s, d, w)); // add the edge to the priority queue
    }

    // Kruskal's algorithm to find Minimum Spanning Tree (MST) of the graph
    void kruskal() {
        // Array to keep track of the parent of each node
        int[] parent = new int[v];

        // Initialize all vertices as belonging to different sets
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }

        // Process edges in increasing order of their weights
        while (!pq.isEmpty()) {
            Edge e = pq.poll(); // retrieve the edge with the minimum weight
            int x = find(e.s, parent); // find the parent of source vertex
            int y = find(e.d, parent); // find the parent of destination vertex

            // If including this edge doesn't cause a cycle, include it in the MST
            if (x != y) {
                System.out.println(e.s + " - " + e.d + " : " + e.w); // print the edge
                union(x, y, parent); // union the two vertices
            }
        }
    }

    // Method to find the parent of a vertex using union-find algorithm
    int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i; // if the vertex is its own parent, return it
        }
        // otherwise, recursively find the parent of the parent
        return parent[i] = find(parent[i], parent);
    }

    // Method to perform union operation to merge two sets
    void union(int x, int y, int[] parent) {
        int xset = find(x, parent); // find the parent of x
        int yset = find(y, parent); // find the parent of y
        if (xset != yset) {
            parent[xset] = yset; // make one parent as the parent of the other
        }
    }

    // Main method to test the Kruskal's algorithm
    public static void main(String[] args) {
        Krushkal_3B graph = new Krushkal_3B(4); // create a graph with 4 vertices

        // Add edges to the graph with their source, destination, and weight
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        // Find and print the Minimum Spanning Tree (MST) of the graph using Kruskal's algorithm
        graph.kruskal();
    }
}

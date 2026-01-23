public class DFT {
    int[][] adj; // Adjacency matrix
    boolean[] visited; // Array to keep track iof visited node
    int[] stack; // Array based stack
    int tos; // Top of stack

    // Constructor
    public DFT(int v) {
        this.adj = new int[v][v];
        visited = new boolean[v];
        stack = new int[v];
        tos = -1;
    }

    public void addEdge(int src, int dest) {
        adj[src][dest] = 1;
        adj[dest][src] = 1;
    }

    public void performDFT(int x) {
        push(x);
        System.out.print("Depth First Traversal: ");

        while (tos != -1) {
            int curr = pop();
            if (!visited[curr]) {
                visited[curr] = true;
                System.out.print(curr + " ");
                for (int i = 0; i < adj.length; i++) {
                    if (adj[curr][i] == 1 && !visited[i]) {
                        push(i);
                    }
                }
            }
        }
    }

    public void push(int node) {
        stack[++tos] = node;
    }

    public int pop() {
        return stack[tos--];
    }

    public static void main(String[] args) {
        DFT dft = new DFT(5);
        dft.addEdge(0, 1);
        dft.addEdge(1, 2);
        dft.addEdge(1, 3);
        dft.addEdge(2, 4);
        dft.performDFT(0);
    }
}

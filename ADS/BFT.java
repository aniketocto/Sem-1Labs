public class BFT
{
    int[][] adj;          // Adjacency Matrix
    boolean[] visited;    // To track visited nodes
    int[] queue;          // Array-based queue
    int front, rear;

    // Constructor
    public BFT(int v)
    {
        adj = new int[v][v];
        visited = new boolean[v];
        queue = new int[v];
        front = -1;
        rear = -1;
    }

    // Add an edge (Undirected Graph)
    public void addEdge(int src, int dest)
    {
        adj[src][dest] = 1;
        adj[dest][src] = 1;
    }

    // Perform Breadth First Traversal
    public void performBFT(int start)
    {
        enqueue(start);
        visited[start] = true;

        System.out.print("Breadth First Traversal: ");

        while (front != -1)   // Queue is not empty
        {
            int curr = dequeue();
            System.out.print(curr + " ");

            // Visit all unvisited neighbors
            for (int i = 0; i < visited.length; i++)
            {
                if (adj[curr][i] == 1 && !visited[i])
                {
                    enqueue(i);
                    visited[i] = true;
                }
            }
        }
    }

    // Enqueue operation
    public void enqueue(int x)
    {
        if (front == -1)
        {
            front = 0;
        }
        queue[++rear] = x;
    }

    // Dequeue operation
    public int dequeue()
    {
        int temp = queue[front];

        if (front == rear)
        {
            front = rear = -1;
        }
        else
        {
            front++;
        }
        return temp;
    }

    // Main Method
    public static void main(String[] args)
    {
        BFT g = new BFT(6);

        // Add edges
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        // Perform BFS starting from node 3
        g.performBFT(3);
    }
}
import java.util.Scanner;

public class AdjMat {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        //take vertices input
        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();

        //Initialize the adjacency matrix
        int adj[][] = new int[v][v];


        //get the number of edge
        System.out.println("Enter the number of edges: ");
        int e = sc.nextInt();

        //take input of edged
        for (int i = 0; i < e; i++) {
            System.out.println("Enter the source and destination: ");
            int src = sc.nextInt();
            int dest = sc.nextInt();

            adj[src][dest] = 1;
            adj[dest][src] = 1;
        }


        System.out.println("Adjacency Matrix: ");
        for (int i = 0; i < v; i++)
        {
            for (int j = 0; j < v; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}
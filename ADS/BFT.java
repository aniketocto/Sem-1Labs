public class BFT 
{ 
int[][] adj;  
boolean[] visited; 
int[] queue;  
int front,rear;  
//constructor 
public BFT(int v) 
{ 
//Adjacency matrix 
//Track visited node 
//Array-based queue 
//Front and rear of the queue 
adj = new int[v][v]; 
visited = new boolean[v]; 
queue = new int[v]; 
front = -1; 
rear = -1; 
} 
//Add an edge 
public void AddEdge(int src,int dest) 
{ 
adj[src][dest] = 1; 
  adj[dest][src] = 1; 
 } 
 
 //Perform BFT 
 public void PerformBFT(int x) 
 { 
  Enqueue(x);  //Enqueue the starting node 
  visited[x] = true; 
   
  System.out.print("Breadth first Traversal:  "); 
  while(front!=-1)  //Queue is not Empty 
  { 
   int curr = Dequeue();  //Dequeue 
   System.out.print(curr+" "); //Process 
  
   for(int i=0 ; i<visited.length ; i++) //Enqueue all unvisited neighbour og curr 
   { 
    if(adj[curr][i]==1 && !visited[i]) 
    { 
     Enqueue(i); 
     visited[i]=true; 
    } 
   } 
  }//end of while 
 } 
 
 //Enqueue 
 public void Enqueue(int x) 
 { 
   
  if(front==-1) 
  { 
   front++;  
  } 
  queue[++rear]= x; 
 } 
  
 //Dequeue 
 public int Dequeue() 
 { 
  int tmp = queue[front]; 
   
  if(front==rear) 
  { 
   front = rear =-1; 
    
  } 
  else 
  { 
   front++; 
  } 
  return tmp; 
 } 
 
 public static void main(String [] args) 
 { 
  BFT g = new BFT(6); 
   
  //Add edges to graph 
  g.AddEdge(0,1); 
  g.AddEdge(0,3); 
  g.AddEdge(1,2); 
g.AddEdge(2,4); 
g.AddEdge(3,4); 
g.AddEdge(3,5); 
g.AddEdge(4,5); 
g.PerformBFT(3); 
} 
}//end of BFT
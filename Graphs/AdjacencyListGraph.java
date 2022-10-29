package Graphs;
import java.util.*;

public class AdjacencyListGraph {
    
    LinkedList<Integer>[] adjList;
    int V; //Number of vertices
    int E; //Number of edges

    public AdjacencyListGraph(int nodes){
        this.V = nodes;
        this.E = 0;
        this.adjList = new LinkedList[nodes];
        for(int v = 0; v < V; v++){
            adjList[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        adjList[u].add(v);
        adjList[v].add(u);
        E++; 
    }

    public static AdjacencyListGraph createSampleGraph(){
        AdjacencyListGraph graph = new AdjacencyListGraph(7);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        return graph;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges" + "\n");
        for(int v = 0; v < V; v++){
            sb.append(v + " : ");
            for(int w : adjList[v]){
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //Breadth first search. Similar to LevelOrder Traversal on Tree, but with the boolean array to ensure no element is visited twice.
    public void bfs(int s){
        boolean[] visited  = new boolean[V];
        Queue<Integer> Q = new LinkedList<>();
        visited[s] = true;
        Q.offer(s);

        while(!Q.isEmpty()){
            int u = Q.poll();

            System.out.print(u + " ");

            for(int v : adjList[u]){
                if(!visited[v]){
                    visited[v] = true;
                    Q.offer(v);
                }
            }
        }
    }
     
    //Iterative depth-first search.
    public void dfsIterative(int s){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        stack.push(s);

        while(!stack.isEmpty()){
            int u = stack.pop();

            if(!visited[u]){
                visited[u] = true;
                System.out.print(u + " ");

                for(int v : adjList[u]){
                    if(!visited[v])
                        stack.push(v);
                }
            }
            
        }
    }

    //Finding number of strongly connected components:
    public int[] GetConnectedComponentsDFS(){
        boolean[] visited = new boolean[V];
        int[] stronglyCompID = new int[V];
        int count = 0;

        for(int v = 0; v < V; v++){
            if(!visited[v]){
                GetConnectedComponentsDFS(v, visited,stronglyCompID, count);
                count++;
            }
        }

        return stronglyCompID;
    }

    private void GetConnectedComponentsDFS(int v, boolean[] visited, int[] stronglyCompID, int count) {
        visited[v] = true;
        stronglyCompID[v] = count;

        for(int w : adjList[v]){
            if(!visited[w]){
                GetConnectedComponentsDFS(w, visited, stronglyCompID, count);
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyListGraph g = createSampleGraph();
        // DFS : 0 3 2 4 1.
        // BFS : 0 1 3 2 4

        int[] res = g.GetConnectedComponentsDFS();

        for(int x : res){
            System.out.print(x + " ");
        }


        


    }

    /*
     * This is the same graph from the Adjacency Matrix Graph File.
     * It's Adjacency List Representation:
     * 
     * 0 index : 1 -> 3
     * 1 index : 0 -> 2
     * 2 index : 1 -> 3
     * 3 index : 2 -> 0
     */
}

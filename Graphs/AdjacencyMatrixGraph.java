package Graphs;

public class AdjacencyMatrixGraph {

    //Row <-> Col must be 1 for every two edges connected.
    /*              0 --- 1
     *              |     |
     *              |     |
     *              3 --- 2      
     *  This Graph's adjacency matrix would be 4x4 as there are 4 nodes on the graph. 
     *  the adjacency matrix for it would be:
     *  
     *  [[0,1,0,1],
     *   [1,0,1,0],
     *   [0,1,0,1], 
     *   [1,0,1,0]]
     */

    int V; //Number of vertices.
    int E; //Number of edges
    int[][] adjMatrix;

    public AdjacencyMatrixGraph(int nodes){
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }
    public void addEdge(int u, int v){
        this.adjMatrix[u][v] = 1;
        this.adjMatrix[v][u] = 1; //Because it's undirected. if it's directed, row -> col only.
        E++;
    }
    public static AdjacencyMatrixGraph createSampleGraph(){
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(4);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        return graph;
    }
    
    //Prints the adjacency matrix.
    public String toString(){
        String res = V + " vertices, and " + E + " edges. \n";

        for(int v = 0; v < V; v++){
            res += v + " : ";
            for(int w : adjMatrix[v]){
                res += w + " ";
            }
            res += "\n";
        }
        
        return res;
    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph g = createSampleGraph();
        System.out.println(g);
    }

}

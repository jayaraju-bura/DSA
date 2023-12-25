import java.util.*;

class MinimumSpanningTree {
    
    class Edge implements Comparable<Edge>{
        int src, dst, weight;
        public int compareTo(Edge tempEdge) {
            return this.weight - tempEdge.weight;
        }
    };
    class subset {
        int parent, rank;
    }
    
    Edge edge[];
    int vertices, edges;
    MinimumSpanningTree(int v, int e) {
        edges = e;
        vertices = v;
        edge = new Edge[edges];
        for(int i=0 ; i < e; ++i) {
            edge[i] = new Edge();
        }
        
    }
        
    int find(subset subsets[], int node) {
        if (subsets[node].parent != node) {
            subsets[node].parent = find(subsets, subsets[node].parent);
        }
        return subsets[node].parent;
    }
        
    void union(subset subsets[], int x, int y){
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if(subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        }
        else if(subsets[yroot].rank > subsets[xroot].rank) {
            subsets[xroot].parent = yroot;
        }
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    
    void KruskalAlgo(){
        Edge result[] = new Edge[vertices];
        for(int i=0 ; i<vertices; i++){
            result[i] = new Edge();
        }
        
        subset subsets[] = new subset[vertices];
        for(int i=0 ; i < vertices; i++){
            subsets[i] = new subset();
        }
        
        for(int i=0 ; i < vertices ; i++){
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        
        int j=0, e=0;
        Arrays.sort(edge);
        while(e < vertices - 1){
            Edge nextEdge = new Edge();
            nextEdge = edge[j++];
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dst);
            if (x != y){
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }
        for(int i=0; i < e; i++){
            System.out.println(result[i].src + "-" +  result[i].dst+ "-" + result[i].weight);
            
        }
    }
    
    public static void main(String []args) {
        System.out.println("Initiating Minimum Spanning Tree Execution :: \n");
        int vertices = 6; // Number of vertices
        int edges = 8; // Number of edges
        MinimumSpanningTree G = new MinimumSpanningTree(vertices, edges);
        G.edge[0].src = 0;
        G.edge[0].dst = 1;
        G.edge[0].weight = 4;
    
        G.edge[1].src = 0;
        G.edge[1].dst = 2;
        G.edge[1].weight = 4;
    
        G.edge[2].src = 1;
        G.edge[2].dst = 2;
        G.edge[2].weight = 2;
    
        G.edge[3].src = 2;
        G.edge[3].dst = 3;
        G.edge[3].weight = 3;
    
        G.edge[4].src = 2;
        G.edge[4].dst = 5;
        G.edge[4].weight = 2;
    
        G.edge[5].src = 2;
        G.edge[5].dst = 4;
        G.edge[5].weight = 4;
    
        G.edge[6].src = 3;
        G.edge[6].dst = 4;
        G.edge[6].weight = 3;
    
        G.edge[7].src = 5;
        G.edge[7].dst = 4;
        G.edge[7].weight = 3;
        G.KruskalAlgo();
    }
}


// Initiating Minimum Spanning Tree Execution :: 

// 1-2-2
// 2-5-2
// 2-3-3
// 3-4-3
// 0-1-4

import java.io.*;
import java.util.*;
class Graph {
    private  int V;
    private LinkedList<Integer>adj[];
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++) {
            adj[i] = new LinkedList();
        }
    }
    
    public  void addEdge(int v, int u) {
        adj[v].add(u);
    }
    
    public void DFSUtil(int ver, boolean visited[]) {
        
        System.out.println(ver + " ");
        visited[ver] = true;
        Iterator<Integer> itr = adj[ver].listIterator();
        while(itr.hasNext()) {
            int data = itr.next();
            if (!visited[data]) {
                DFSUtil(data, visited);
                
            }
        }
        
    }
    
    public void DFS(int src) {
        boolean visited[] = new boolean[V];
        DFSUtil(src, visited);
    }
    public static void main(String[] args) {
        System.out.println("Depth First Search for the below created Graph is -> ");
        Graph g = new Graph(4);
        g.addEdge(2, 0);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(0, 1);
        g.addEdge(3, 3);
        g.addEdge(1, 3);
        g.DFS(0);
        
    }
}

import java.io.*;
import java.util.*;

class BFSGraphTraversal {
    
    private Integer Vertex;
    private LinkedList<Integer> adj[];
    BFSGraphTraversal(int v) {
        Vertex = v;
        adj = new LinkedList[v];
        for (int idx = 0; idx<v; idx++) {
            adj[idx] = new LinkedList();
        }
    }
    
    public  void addEdge(int src, int dest) {
        adj[src].add(dest);
    }
    
    public void BFS(int src) {
        
        boolean visited[] = new boolean[Vertex];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(src);
        visited[src] = true;
        while(queue.size() != 0){
            int item = queue.poll();
            System.out.print(item);
            Iterator<Integer> itr = adj[item].listIterator();
            while(itr.hasNext()) {
                int n = itr.next();
                if(!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                }
                
            }
            if (queue.size() != 0){
                System.out.print(" -> ");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Running BFS Traveral on the Graph :: ");
        BFSGraphTraversal grph = new BFSGraphTraversal(4);
        grph.addEdge(0, 1);
        grph.addEdge(0, 2);
        grph.addEdge(1, 2);
        grph.addEdge(2, 0);
        grph.addEdge(2, 3);
        grph.addEdge(3, 3);
    
    System.out.println("BFS Traversal of the above graph starting from 3 is ::::");
    grph.BFS(2);
    }
}

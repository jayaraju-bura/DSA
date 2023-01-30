/******************************************************************************
Dijkstra Shortest Path Algorithm
*******************************************************************************/
public class Dijkstra
{
    public static void dijkstra(int graph[][], int source) {
        int node_count  = graph.length;
        boolean visited[] = new boolean[node_count];
        int dist[] = new int[node_count];
        int prev_node[] = new int[node_count];
        for (int idx=0; idx < node_count; idx++) {
            visited[idx] = false;
            dist[idx] = Integer.MAX_VALUE;
            prev_node[idx] = source;
        }
        dist[source] = 0;
        prev_node[source] = -1;
        for(int idx=0 ; idx < node_count; idx++) {
            int u = findMinDistance(dist, visited);
            visited[u] = true;
            for(int v=0; v < node_count; v ++) {
                if(!visited[v] && graph[u][v] != 0 &&dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    prev_node[v] = u;
                }
            }
        }
        System.out.println("The shortest distance from source node to every neighbour node in the graph is ");
        for(int idx=0; idx < node_count; idx++) {
            System.out.println("To " + idx + " : " + dist[idx] +  " , previous node :" + prev_node[idx]);
        }
        
    }
    private static int findMinDistance(int dist[], boolean visited[]) {
        int length = dist.length;
        int minDistVertex = -1;
        int minDistance = Integer.MAX_VALUE;
        for(int i=0; i < length; i++) {
            if(!visited[i] && dist[i] < minDistance) {
                minDistance = dist[i];
                minDistVertex = i;
            }
        }
        
        return minDistVertex;
        
    }
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 2, 0, 0, 3, 0 }, { 1, 2, 0, 1, 3, 0, 0 },
        { 2, 0, 1, 0, 0, 0, 1 }, { 0, 0, 3, 0, 0, 2, 0 }, { 0, 3, 0, 0, 2, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0 } };
        Dijkstra inst = new Dijkstra();
        inst.dijkstra(graph, 0);
    
  }
}

/******************************************************************************
Hello World
The shortest distance from source node to every neighbour node in the graph is 
To 0 : 0 , previous node :-1
To 1 : 3 , previous node :2
To 2 : 1 , previous node :0
To 3 : 2 , previous node :0
To 4 : 4 , previous node :2
To 5 : 4 , previous node :6
To 6 : 3 , previous node :3
*******************************************************************************/

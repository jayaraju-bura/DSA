import java.io.*;
import java.util.*;

public class ConnectedComponents {
    public static void dfsutil(int ver, boolean[] visited, int[][] roads){
        visited[ver] = true;
        for(int i=0; i<roads.length;i++){
            if(roads[ver][i] == 1 && !visited[i]){
                dfsutil(i, visited, roads);
            }
        }
    }
    public static int findNumOfProvinces(int[][] roads, int n) {
        int connected_components = 0;
        boolean visited[] = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfsutil(i, visited, roads);
                connected_components++;
            }
        }

        return connected_components;
    }
    
    public static void main(String args[]){
        int[][] graph = { {1, 0, 0}, {0, 1, 0}, {0, 0, 1} };
        System.out.println("number of connected components :: " + findNumOfProvinces(graph, graph.length));
    }
}

//number of connected components :: 3

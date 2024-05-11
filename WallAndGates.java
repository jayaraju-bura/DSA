// You are given an m x n grid rooms initialized with these three possible values.

// -1 A wall or an obstacle.
// 0 A gate.
// INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
import java.util.*;
class WallAndGates {
    
    public static void printGrid(int[][] rooms) {
        int row = rooms.length;
        int col = rooms[0].length;
        for (int i=0; i < row ; i ++) {
            for(int j=0 ; j < col; j++) {
                System.out.print(rooms[i][j]+ "       ");
            }
            System.out.println("\t\t");
            
        }
        
    }
    public static void calculateDistance(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        int adj_rows[] = {0, -1, 0, 1};
        int adj_cols[] = {-1, 0, 1, 0};
        Deque<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            for(int j=0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int d = 0;
        while(!queue.isEmpty()) {
            ++d;
            for (int i = 0; i<queue.size(); i++) {
                int[] p = queue.poll();
                for(int j=0; j<4; j++){
                    int x = p[0] + adj_rows[j];
                    int y = p[1] + adj_cols[j];
                    
                    if (x >=0 && x < rows && y < cols && y>=0 && rooms[x][y] == Integer.MAX_VALUE) {
                        rooms[x][y] = d;
                        queue.offer(new int[]{x, y});
                    }
                }
             }
            
        }
        
    }
    public static void main(String[] args) {
        System.out.println("Walles and Gates leetcode question");
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,-1,-1},{0,-1,2147483647,2147483647}};
        
        printGrid(rooms);
        calculateDistance(rooms);
        System.out.print("\n\n");
        printGrid(rooms);
        
    
}
}


// Walles and Gates leetcode question
// 2147483647       -1       0       2147483647       		
// 2147483647       2147483647       2147483647       -1       		
// 2147483647       -1       -1       -1       		
// 0       -1       2147483647       2147483647       		


// 4       -1       0       1       		
// 2       2       1       -1       		
// 1       -1       -1       -1       		
// 0       -1       2147483647       2147483647       		

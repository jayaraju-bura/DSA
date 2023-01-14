import java.io.*;
import java.util.*;

class checkPathTopLeftBottomRight {
    
    static boolean is_valid(int x, int y, int[][] grid) {
        
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return false;
        }
        return true;
        
    }
    
    static void dfs(int x, int y, int[][] grid, boolean[][] visited) {
        
        if(visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        int up = 0, down = 0, right = 0, left = 0;
        if (grid[x][y] == 1){
            left = 1;
            right = 1;
        }
        else if (grid[x][y] == 2) {
            up = 1;
            down = 1;
        }
        else if (grid[x][y] == 3) {
            left = 1;
            down = 1;
        }
        else if (grid[x][y] == 4) {
            right = 1;
            down = 1;
        }
        else if (grid[x][y] == 5) {
            left = 1;
            up = 1;
        }
        else if (grid[x][y] == 6) {
            right = 1;
            up = 1;
        }
        
        if (up != 0) {
            int new_x = x-1, new_y = y;
            if(is_valid(new_x, new_y, grid) && (grid[new_x][new_y] == 2 || grid[new_x][new_y] == 3 || grid[new_x][new_y] == 4))
            {
                dfs(new_x, new_y, grid, visited);
            }
        }
        if (down != 0) {
            int new_x = x+1, new_y = y;
            if(is_valid(new_x, new_y, grid) && (grid[new_x][new_y] == 2 || grid[new_x][new_y] == 5 || grid[new_x][new_y] == 6))
            {
                dfs(new_x, new_y, grid, visited);
            }
        }
        if (left != 0) {
            int new_x = x, new_y = y-1;
            if(is_valid(new_x, new_y, grid) && (grid[new_x][new_y] == 1 || grid[new_x][new_y] == 6 || grid[new_x][new_y] == 4))
            {
                dfs(new_x, new_y, grid, visited);
            }
        }
        if (right != 0) {
            int new_x = x, new_y = y+1;
            if(is_valid(new_x, new_y, grid) && (grid[new_x][new_y] == 1 || grid[new_x][new_y] == 3 || grid[new_x][new_y] == 5))
            {
                dfs(new_x, new_y, grid, visited);
            }
        }
        
        
    }
    public static void main(String[] args) {
       int[][] grid = {{2, 4, 3}, {6, 5, 2}};
       int N = grid.length;
       int M = grid[0].length;
       boolean[][] visited = new boolean[N][M];
       dfs(0, 0, grid, visited);
       if (visited[N-1][M-1]) {
           System.out.println("Path exists");
       }
       else {
           System.out.println("Path doesn't exist");
       }
       
    }
}

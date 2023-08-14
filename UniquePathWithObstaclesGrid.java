import java.io.*;

class UniquePathWithObstaclesGrid {
    static int m, n;
    static int path(int i, int j, int[][] grid, int[][] dp) {
        
        if(i < m && j < n && grid[i][j] == 1){
            return 0;
        }
        if(i == m-1 && j == n-1) {
            return 1;
        }
        
        if(i >= m || j >= n) {
            return 0;
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        
        
        int left = path(i+1, j, grid, dp);
        int right = path(i, j+1, grid, dp);
        return dp[i][j] = left + right;
    }
    
    
    static int uniquePathsWithObstacles(int grid[][]) {
        m = grid.length;
        n = grid[0].length;
        if(m == 1 && n ==1 && grid[0][0] == 0){
            return 1;
        }
        if(m == 1 && n == 1 && grid[0][0] == 1) {
            return 0;
        }
        int dp[][] = new int[m][n];
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++)
            {
                dp[i][j] = -1;
            }
        }
        path(0, 0, grid, dp);
        if(dp[0][0] == -1){
            return 0;
        }
        return dp[0][0];
    }
    public static void main(String args[]) {
        int[][] v = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, {1, 0, 0} };
        System.out.println(uniquePathsWithObstacles(v));
    }
   
}

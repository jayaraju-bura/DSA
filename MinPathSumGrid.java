class MinPathSumGrid {
    public static  int minPathSum(int[][] grid) {
        int length = grid.length;
        int col_length = grid[0].length;
        int dp[][] = new int[length][col_length];
        dp[0][0] = grid[0][0];
        for(int i=1; i < col_length; i++)
            dp[0][i] = dp[0][i-1] + grid[0][i];
        for(int i=1; i < length; i++)
            dp[i][0] = dp[i-1][0] + grid[i][0];
        for(int i=1; i<length; i++ ){
            for(int j=1; j<col_length; j++){
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[length-1][col_length-1];
    }
    
    public static void main(String args[]){
        int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
        System.out.println("minimum path sum to reach bottom of the grid from top left  --> " + minPathSum(cost));
    }
}


//minimum path sum to reach bottom of the grid from top left  --> 11

class MinPathSumTriangle {
    public static int helper(List<List<Integer>> triangle, int row, int col, int[][] dp){

        if (row == triangle.size()){
            return 0;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }

        return dp[row][col] = triangle.get(row).get(col) + Math.min(helper(triangle, row+1, col+1, dp), helper(triangle, row+1, col, dp));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
       int length = triangle.size();
       int dp[][] = new int[length][length];
       for(int[] row: dp){
           Arrays.fill(row, -1);
       }

       return helper(triangle, 0, 0, dp);
    }

    public static void main(String args[]){
      int A [][] = { { 2 },
                  { 3, 9 },
                  { 1, 6, 7 } };
      System.out.print(minimumTotal(A));
    }
}

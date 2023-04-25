class KnapsackMemoization {
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    public static int knapsackUtil(int W, int wt[], int val[], int n, int dp[][]) {
        
        if (n == 0 || W == 0){
            return 0;
        }
        
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n-1] > W) {
            return dp[n][W] = knapsackUtil(W, wt, val, n-1, dp);
        }
        else {
            return dp[n][W] = max(val[n-1]+knapsackUtil(W-wt[n-1], wt, val, n-1, dp), knapsackUtil(W, wt, val, n-1, dp));
        }
        
    }
    
    public static int knapsack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n+1][W+1];
        for (int i=0; i<=n; i++) {
            for(int j=0; j<=W;  j++) {
                
                dp[i][j] = -1;
            }
        }
        
        return knapsackUtil(W, wt, val, n, dp);
    }
    public static void main(String[] args) {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int Weight = 50;
        int n = profit.length;
        System.out.println("Hello, World!");
        System.out.println("The maximum value obtained by selecting the items into bag is :- " + knapsack(Weight,  weight, profit, n));
    }
}

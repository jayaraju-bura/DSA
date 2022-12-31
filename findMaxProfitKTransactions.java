// Program to compute Maximum profit for stock in k transactions given the price of the stock for n days
class Solution {
    
    public static int findMaxProfit(int price[], int k)
    {
        int n = price.length;
        if (n <=1) {
            return 0;
        }
        int[][] profit = new int[k+1][n];
        for (int i=0; i<=k; i++) {
            for(int j=0; j<n; j++) {
                if (i == 0 || j == 0) {
                    profit[i][j] = 0;
                }
                else
                {
                    int max_so_far = 0;
                    for(int x=0; x<j;x++) {
                        
                        int current_so_far = price[j] - price[x] + profit[i-1][x];
                        if (max_so_far < current_so_far) {
                            max_so_far = current_so_far;      
                        }

                    }
                    
                    profit[i][j] = Math.max(profit[i][j-1], max_so_far);
                }
            }
        }
        
        return profit[k][n-1];
    }
    public static void main(String []args) {
        
        int[] price = {1, 5, 45, 34, 7, 6, 4, 14};
        int k = 3;
        System.out.println("The Maximum Profit with in k transactions is " + findMaxProfit(price, k) );
        
        
    }
}


//The Maximum Profit with in k transactions is 54

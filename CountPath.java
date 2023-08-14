import java.io.*;

class CountPath {
    static int countNumberOfPaths(int m, int n) {
        int[][] count = new int[m][n]; 
        for(int i=0; i<m;i++)
            count[i][0] = 1;
        for(int j=0;j<n;j++)
            count[0][j] = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (i == 0 || j ==0) {
                    count[i][j] = 1;
                }
                else{
                    count[i][j] = count[i-1][j] + count[i][j-1];
                }
            }
        }
        return count[m-1][n-1];
    }
    public static void main(String args[]){
        System.out.println("Number of paths from cell at (3,3) to leftmost cell :: " + countNumberOfPaths(3, 3));
    }
}

class Nqueen {
    final int N = 4;
    void printSolution(int board[][]) {
        for(int i=0 ; i< N; i++) {
            for(int j=0 ; j < N; j++) {
                if(board[i][j] == 1){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("[] ");
                }
            }
            System.out.println();
        }
        
    }
    boolean isSafe(int board[][], int row, int col) {
        int i, j;
        for(i=0; i<col; i++){
            if(board[row][i] == 1){
                return false;
                
            }
        }
        
        for(i=row, j=col; i >=0 && j>=0 ; i--, j--){
            if(board[i][j] == 1){
                return false;
            }
            
        }
        
        for(i=row, j=col; i < N && j>=0 ; i++, j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        
        return true;
    }
        
    boolean nQueenUtil(int board[][], int col) {
        if(col >= N)
        {
            return true;
        }
        
        for(int i=0; i<N; i++) {
            if(isSafe(board, i, col)) {
                
                board[i][col] = 1;
                if(nQueenUtil(board, col + 1)){
                    return true;
                }
                board[i][col] = 0;
            }
        }
        
        return false;
        
    }
    
    boolean nQueenSol() {
        
        int board[][] = { {0, 0, 0, 0} , {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0} };
        if(nQueenUtil(board, 0)){
            printSolution(board);
            return true;
        }
        else {
            System.out.println("Solution doesn't exist");
            return false;
        }
        
        
    }
    public static void main(String[] args) {
        Nqueen inst = new Nqueen();
        inst.nQueenSol();
        
    }
}

class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        char[][] nQueens = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(nQueens[i],'.');
        }
        solve(n,nQueens,0);
        return count;
    }

    public void solve(int n,char[][] nQueens,int row){
        if(row==n){
            count++;
            return;
        }

        for(int col=0;col<n;col++){
            if(isSafe(n,nQueens,row,col)){
                nQueens[row][col] = 'Q';
                solve(n,nQueens,row+1);
                nQueens[row][col] = '.';
            }
        }
    }
    public boolean isSafe(int n,char[][] nQueens,int row,int col){
        // Col me check krlo agr pehle se hi Q hai toh 
        for(int i=0;i<n;i++){
            if(nQueens[i][col] == 'Q'){
                return false;
            }
        }

        // Upper left diagonal 
        for(int i = row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(nQueens[i][j] == 'Q'){
                return false;
            }
        }

        // Upper right diagonal
        for(int i = row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(nQueens[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
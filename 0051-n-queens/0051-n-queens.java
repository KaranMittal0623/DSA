class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // Empty 2-d array initialize krlo
        char[][] nQueens = new char[n][n];
        // hr jgaah . se fill krlo
        for(int i=0;i<n;i++){
            Arrays.fill(nQueens[i],'.');
        }
        solveNQueens(n,result,nQueens,0);
        return result;
    }

    public void solveNQueens(int n,List<List<String>> result,char[][] nQueens,int row){
        // Agr base case reach hora hmne sare traverse krle toh complete complete row ko string me convert krke result me add krdo
        if(row==n){
            List<String> sol = new ArrayList<>();
            for(char[] arr : nQueens){
                sol.add(new String(arr));
            }
            result.add(sol);
            return;
        }

        // Hr ek point pr loop lgakr check kro ki agr vaha Q safe hai toh place krdo
        for(int col = 0;col<n;col++){
            if(isSafe(n,nQueens,row,col)){
                nQueens[row][col] = 'Q';
                solveNQueens(n,result,nQueens,row+1);
                // Agr nhi possible toh back track krte krte us place se Q ko remove krdo
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
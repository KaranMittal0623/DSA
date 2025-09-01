class Solution {
    public void setZeroes(int[][] matrix) {
        // Optimal Approach
        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstRowAffected = false;
        boolean firstColAffected = false;

        for(int i=0;i<row;i++){
            if(matrix[i][0]==0){
                firstColAffected = true;
                break;
            }
        }
        for(int i=0;i<col;i++){
            if(matrix[0][i]==0){
                firstRowAffected = true;
                break;
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][0] == 0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRowAffected){
            for(int i=0;i<col;i++){
                matrix[0][i] = 0;
            }
        }
        if(firstColAffected){
            for(int i=0;i<row;i++){
                matrix[i][0] = 0;
            }
        }

        

    }
}
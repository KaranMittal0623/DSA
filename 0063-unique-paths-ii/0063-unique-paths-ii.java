class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] memo = new int[row][col];
        for(int[] arr: memo){
            Arrays.fill(arr,-1);
        }
        return findPath(obstacleGrid,0,0,row,col,memo);
    }

    public int findPath(int[][] obstacleGrid, int i, int j,int row, int col,int[][] memo){
        if(i>=row || j>=col || obstacleGrid[i][j] == 1){
            return 0;
        }
        
        if(i == row-1 && j == col-1){
            return 1;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        

        int right = findPath(obstacleGrid,i,j+1,row,col,memo);
        int down = findPath(obstacleGrid,i+1,j,row,col,memo);

        return memo[i][j] = right+down;
    }
}
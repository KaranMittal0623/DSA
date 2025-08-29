class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] memo = new Integer[m][n];
        return findPath(grid, 0, 0, m, n, memo);
    }

    public int findPath(int[][] grid, int i, int j, int rows, int cols,Integer[][] memo){
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        if(i == rows-1 && j == cols-1){
            return memo[i][j] = grid[i][j];
        }
        if(j==cols-1){
            memo[i][j] = grid[i][j] + findPath(grid,i+1,j,rows,cols,memo);
        }
        else if(i == rows-1){
            memo[i][j] = grid[i][j] + findPath(grid,i,j+1,rows,cols,memo);
        }
        else{
            memo[i][j] = grid[i][j] + Math.min(findPath(grid,i+1,j,rows,cols,memo), findPath(grid,i,j+1,rows,cols,memo));
        }
        return memo[i][j];
    }
}
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Greedy approach but it is failing 
        // int sum = triangle.get(0).get(0);
        // int idx = 0;;
        // for(int i = 1;i<triangle.size();i++){
        //     int min = Math.min(triangle.get(i).get(idx) , triangle.get(i).get(idx+1));
        //     if(min == triangle.get(i).get(idx+1)){
        //         idx++;
        //     }
        //     sum += min;
        // }
        // return sum;


        // Optimal code with dp start from last row and come toward upward and return the min sum 
        int height = triangle.size();
        int[][] dp = new int[height+1][height+1];
        for(int level = height-1;level>=0;level--){
            // last row se start krkek upr ke ayenge hr row fill krte rehenge min value ke saath
            for(int i=0;i<=level;i++){
                dp[level][i] = triangle.get(level).get(i) + Math.min(dp[level+1][i] , dp[level+1][i+1]);
            }
        }
        return dp[0][0];
    }
}
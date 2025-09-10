class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] resultDp = new int[l1+1][l2+1];


        for(int i=1;i<=l1;i++){
            resultDp[i][0] = i;
        }
        for(int j=1;j<=l2;j++){
            resultDp[0][j] = j;
        }

        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(word1.charAt(i -1) == word2.charAt(j - 1)){
                    resultDp[i][j] = resultDp[i-1][j-1];
                }
                else{
                    int topDiagonal = resultDp[i-1][j-1];
                    int left = resultDp[i][j-1];
                    int top = resultDp[i-1][j];
                    resultDp[i][j] = Math.min(topDiagonal,Math.min(left,top)) + 1;
                }
            }
        }
        return resultDp[l1][l2];
    }
}
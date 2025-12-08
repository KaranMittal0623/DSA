class Solution {
    public int findCircleNum(int[][] isConnected) {
        // Is question mei hum simple traverse krke check krte rhenge ki agr voh node connected hai agge vaale se toh agge aage check krte rhenge or jaha jaakr break hoga fr vaha count ko increment kr denge and visited ko true mark krte rhenge..
        
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(visited,i,isConnected,n);
                count++;
            }
        }
        return count;
    }

    public void dfs(boolean[] visited,int node,int[][] isConnected,int n){
        visited[node] = true;
        for(int i = 0;i<n;i++){
            if(isConnected[node][i] == 1 && !visited[i]){
                dfs(visited,i,isConnected,n);
            }
        }
    }
}
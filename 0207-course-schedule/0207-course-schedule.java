class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Topological Sort, BFS along with queue
        // In this question we need to detect the cycle in the graph, if cycle exist then false 
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i=0;i<=numCourses;i++){
            graph.add(new ArrayList<>());
        }

        // Fill the map to store the prerequisites of each 
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        int count =0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;
            for(int next : graph.get(curr)){
                inDegree[next]--;
                if(inDegree[next]==0) queue.offer(next);
            }
        }
        return count == numCourses;
    }
}
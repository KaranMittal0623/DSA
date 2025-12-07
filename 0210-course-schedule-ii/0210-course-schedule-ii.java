class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        // Store in map
        for(int pre[] : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        // Queue to add the immidiately taking courses
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;
        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            result[index++] = curr;
            count++;
            for(int next : graph.get(curr)){
                inDegree[next]--;
                if(inDegree[next]==0) queue.offer(next);
            }
        }
        if(count==numCourses){
            return result;
        }
        else{
            return new int[0];
        }
    }
}
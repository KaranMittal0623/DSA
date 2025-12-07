class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Special case: if n == 1, return [0]
        if (n == 1) {
            return Collections.singletonList(0);
        }
        
        // Build graph and calculate degrees
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n];
        
        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
            
            degree[u]++;
            degree[v]++;
        }
        
        // Initialize queue with leaf nodes (degree == 1)
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                leaves.offer(i);
            }
        }
        
        // Process leaves layer by layer
        int remainingNodes = n;
        while (remainingNodes > 2) {
            int leavesCount = leaves.size();
            remainingNodes -= leavesCount;
            
            for (int i = 0; i < leavesCount; i++) {
                int leaf = leaves.poll();
                
                // Process neighbors
                for (int neighbor : graph.get(leaf)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }
        
        // Collect results
        List<Integer> result = new ArrayList<>();
        while (!leaves.isEmpty()) {
            result.add(leaves.poll());
        }
        
        return result;
    }
}
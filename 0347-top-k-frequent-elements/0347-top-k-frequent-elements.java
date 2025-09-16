class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }

        // Now create the Priority queue for the top frequent values stroing their object and compare them with their frequency
       PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());


        // Add entries to heap storing only k elements
        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        

        // Now add them all in array to return
        int[] result = new int[minHeap.size()];
        for(int i=0;i<k;i++){
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
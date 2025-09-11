class Solution {
    public int findKthLargest(int[] nums, int k) {

        // Using the priority queue
        // Just maintain queue of size k..add one by one and if the queue size gets greater than the k just pop the element from the top of the queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            minHeap.offer(nums[i]);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
class MedianFinder {
    PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(leftHeap.isEmpty() || num<=leftHeap.peek()){
            leftHeap.offer(num);
        }
        else{
            rightHeap.offer(num);
        }

        // Balance
        if(leftHeap.size()<rightHeap.size()){
            leftHeap.offer(rightHeap.poll());
        }
        else if(leftHeap.size()>rightHeap.size()+1){
            rightHeap.offer(leftHeap.poll());
        }
    }
    public double findMedian(){
        if(leftHeap.size() == rightHeap.size()){
            return (leftHeap.peek() + rightHeap.peek()) * 1.0 / 2.0;
        }
        return leftHeap.peek() * 1.0;
    }
    
    // public double findMedian() {
    //     int size = track.size();
    //     PriorityQueue<Integer> temp = new PriorityQueue<>(track);

    //     for(int i=0;i<(size+1)/2 -1;i++){
    //         temp.poll();
    //     }

    //     if(size%2==0){
    //         return ((double) (temp.poll() + temp.poll())) /2;
    //     }
    //     return (double) temp.poll();
    // }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
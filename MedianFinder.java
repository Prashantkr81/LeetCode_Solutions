class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>(); // upper half  ie larger numbers
        maxHeap = new PriorityQueue<>((a,b) -> b-a); // lower half ie smaller numbers
    }
    
    public void addNum(int num) {
        minHeap.add(num);

        // If minHeap gets too big (more than 1 element larger than maxHeap),  move its smallest element to maxHeap to maintain balance
        if(maxHeap.size()+1 < minHeap.size()) maxHeap.add(minHeap.poll());

        // If the biggest number in maxHeap is greater than the smallest in minHeap, swap them to keep order correct
        if(!maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            minHeap.add(maxHeap.poll());
            maxHeap.add(minHeap.poll());
        }
    }
    public double findMedian() {
        // If heaps have different sizes, minHeap has 1 extra element its top is the median
        if(minHeap.size() > maxHeap.size()) return minHeap.peek();
        return (minHeap.peek() + maxHeap.peek())/2.0;
    }
}

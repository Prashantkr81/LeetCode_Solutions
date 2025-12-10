class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();  // if length of a is greater than by means by default its greater num...here a.len - b.len returning +ve val means put a first..of if -ve...put b first
            }
            return a.compareTo(b); //lexicographical comaprison character by character
        });

        for(String num: nums){
            minHeap.add(num);

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}

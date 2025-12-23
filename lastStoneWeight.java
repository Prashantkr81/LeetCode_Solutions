class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return 1;
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>((a,b)->b-a);

        for(int wt: stones) maxHeap.add(wt);

        while(maxHeap.size()>1){
            int y= maxHeap.poll();
            int x= maxHeap.poll();
            if(x==y) continue;
            maxHeap.add(Math.abs(x-y));
        }
        if(maxHeap.size()==0) return 0;
        return maxHeap.peek();
    }
}

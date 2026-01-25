class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n= nums.length;
        int result[]= new int[n-k+1];

        ArrayDeque<Integer> dq= new ArrayDeque<>();

        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        int j=0;
        result[j++]= nums[dq.peek()];

        for(int i=k; i<n; i++){
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            result[j++]= nums[dq.peekFirst()]; 
        }
        return result;
    }
}

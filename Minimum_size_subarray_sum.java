class Solution {

//minimum size subarray whose sum >= target...thats why we keep shrinking window till sum>= target...which was requirement of Q
    public int minSubArrayLen(int target, int[] nums) {
        
        int ans= Integer.MAX_VALUE;
        int i=0, j= 0, curr=0;
        while(j < nums.length){

            curr+= nums[j];
            j++;
            while(curr >= target){
                ans= Math.min(j-i, ans);
                curr-=nums[i];
                i++;
            }
        }
        return ans==Integer.MAX_VALUE ? 0: ans;
    }
}

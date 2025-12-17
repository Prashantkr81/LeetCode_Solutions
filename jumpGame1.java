class Solution {
    public boolean canJump(int[] nums) {
        
        if(nums[0]==0 && nums.length==1) return true;
        int farest=0;

        for(int i=0; i<nums.length; i++){
            if(i > farest)  //as soon our current index become unrachable return false
                return false;
            farest= Math.max(farest, i+ nums[i]);
        }
        return true;
    }
}

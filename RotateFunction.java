class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int total=0; int n= nums.length;

        int f[]= new int[n];

        for(int i=0; i<n; i++){
            total+= nums[i];
            f[0]+= i* nums[i];
        }

        int ans= f[0];
        for(int k=1; k<n; k++){
            f[k]= f[k-1] + total - (n * nums[n-k]);
            ans= Math.max(ans, f[k]);
        }
        return ans;        
    }
}

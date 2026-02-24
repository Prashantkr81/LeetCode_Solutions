class Solution {
    public int maxProduct(int[] nums) {
        
        int n= nums.length;
        int prefix[]= new int[n];
        int suffix[]= new int[n];

        int min= Integer.MIN_VALUE;

        int temp=1;
        for(int i=0; i<n; i++){
            if(temp==0) temp=1;
            temp *= nums[i];
            prefix[i]= temp;
        }
        temp=1;
        for(int i=n-1; i>=0; i--){
            if(temp==0) temp=1;
            temp*= nums[i];
            suffix[i]= temp;
        }
        int ans=min;
        for(int i=0; i<n; i++){
            ans= Math.max(ans, Math.max(prefix[i], suffix[i]));
        }

        return ans;
    }
}

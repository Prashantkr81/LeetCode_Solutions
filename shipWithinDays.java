class Solution {
    public boolean canShip(int weights[], int days, int capacity){
        int daysNeed=1;
        int currentSum=0;
        for(int i=0; i<weights.length; i++){
            if(currentSum+weights[i] > capacity){
                daysNeed++; //we increase day count when sum > capacity
                currentSum=0;   // reset the sum as that ship depart
            }
            currentSum+=weights[i];
        }
        return daysNeed <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int maxCapacity=0;
        int minCapacity=0;

        for(int w: weights){
            minCapacity= Math.max(minCapacity, w); //minCapacity wil be max of weights
            maxCapacity+= w; //total weight
        }

        int l=minCapacity , r= maxCapacity;

        int ans=0;

        while(l<=r){
            int mid= l+(r-l)/2;
            
            if(canShip(weights, days, mid)){
                ans = mid;
                r= mid-1;
            }
            else l= mid+1;
        }
        return ans;
    }
}

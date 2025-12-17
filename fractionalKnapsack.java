class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n = val.length;
        
        double item[][] =  new double[n][3]; //val/wt
        
        for(int i=0; i<n; i++){
            item[i][0] = val[i];
            item[i][1] = wt[i];
            item[i][2] = (double)val[i]/wt[i];
        }
        
        Arrays.sort(item, (a,b)-> Double.compare(b[2], a[2]));
        
        double ans=0.0;
        
        for(int i=0; i<n; i++){
            
            if(item[i][1] <= capacity){
                ans+= item[i][2]*item[i][1];    //take full
                capacity -= item[i][1];
            }
            else{
                ans+= item[i][2] * capacity;    //capacity here less than any wt so fractionl pickup
                capacity=0;
            }
        }
        return ans;
    }
}

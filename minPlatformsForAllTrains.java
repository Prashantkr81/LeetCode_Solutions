import java.util.*;
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i=0, j=0, platform=0, max=0;
        int n= arr.length;
        
        while(i< n && j<n){
            if(arr[i] <= dep[j]){
                platform++; i++;
            }
            else{
                platform--; j++;
            }
            max= Math.max(max, platform);
        }
        return max;
    }
}

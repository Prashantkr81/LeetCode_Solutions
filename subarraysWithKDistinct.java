class Solution {  //Brute Force
    public int subarraysWithKDistinct(int[] nums, int k) {
        int ans=0;
        int n= nums.length;
        for(int i=0; i<n; i++){
            HashSet<Integer> set= new HashSet<>();
            for(int j=i; j<n; j++){
                set.add(nums[j]);
                if(set.size()==k) ans++;
                if(set.size()>k) break;
            }
        }
        return ans;
    }
}  

//optimal

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return atMost(nums, k) - atMost(nums, k-1);
    }
    private int atMost(int nums[], int k){
        int ans=0;
        int i=0, j=0;
        int n= nums.length;

        HashMap<Integer, Integer> map= new HashMap<>();

        while(j<n){
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);

            while(map.size()>k){
                map.put(nums[i], map.get(nums[i]) -1);
                if(map.get(nums[i])==0) map.remove(nums[i]);
                i++;
            }
            ans+= j-i+1;
            j++;
        }
        return ans;
    }
}

here we are calculating exact k distinct by subtracting k-1 subarrays from k wale subarrays

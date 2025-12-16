class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        ArrayDeque<Integer> stk= new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>(nums2.length);

        for(int i=nums2.length-1; i>=0; i--){
            int current= nums2[i];

            while(!stk.isEmpty() && current>=stk.peek()) stk.pop();
            int nxtGreater= stk.isEmpty()? -1: stk.peek();
            map.put(current, nxtGreater);
            stk.push(current);
        }
        int result[]= new int[nums1.length];
        for(int i=0 ; i<result.length; i++){
            result[i]= map.get(nums1[i]);
        }
        return result;
    }
}

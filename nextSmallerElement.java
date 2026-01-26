class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        Stack<Integer> stk= new Stack<>();
        
        ArrayList<Integer> ans= new ArrayList<>();
        
        for(int i=arr.length-1; i>=0; i--){
            
            while(stk.size()!=0 && stk.peek() >= arr[i])
                stk.pop();
            
            if(stk.size()!=0)
            ans.add(stk.peek());
            else ans.add(-1);
            
            stk.push(arr[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
}

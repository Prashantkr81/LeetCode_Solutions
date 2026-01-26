class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        Stack<Integer> stk= new Stack<>();
        
        ArrayList<Integer> ans= new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            
            while(stk.size()!=0 && stk.peek() >= arr[i])
                stk.pop();
            
            if(stk.size()!=0)
            ans.add(stk.peek());
            else ans.add(-1);
            
            stk.push(arr[i]);
        }
        return ans;
    }
}

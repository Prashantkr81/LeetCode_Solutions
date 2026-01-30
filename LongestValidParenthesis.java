class Solution {
    public int longestValidParentheses(String s) {
        ArrayDeque<Integer> stk= new ArrayDeque<>();
        stk.push(-1);
        int max=0;

        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(c=='(') stk.push(i);
            else{
                stk.pop();
                if(stk.isEmpty()) stk.push(i);
                
                else max= Math.max( max, i- stk.peek());
            }
        }
        return max;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n= heights.length;
        if(n==1) return heights[0];
        
        ArrayDeque<Integer> stk= new ArrayDeque<>();
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];
        
        for(int i=n-1; i>=0; i--){
            while(stk.size()!=0 && heights[stk.peek()] >= heights[i])
                stk.pop();
            
            if(stk.size()!=0)
                nextSmaller[i]= stk.peek();
            else nextSmaller[i]= n;
            stk.push(i);
        }

        stk.clear();

        for(int i=0; i<n; i++){
            while(stk.size()!=0 && heights[stk.peek()] >= heights[i])
                stk.pop();
            
            if(stk.size()!=0)
                prevSmaller[i] = stk.peek();
            else prevSmaller[i]= -1;
            
            stk.push(i);
        }
        
        int maxArea= 0;
        for(int i=0; i<heights.length; i++){

            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area  = width * heights[i];
            maxArea= Math.max(area, maxArea);
        }
        return maxArea;
    }
}

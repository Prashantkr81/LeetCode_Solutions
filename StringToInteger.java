class Solution {
    public int myAtoi(String s) {
        
        s= s.trim();  // remove leading extra space

        if(s.length()==0) return 0;

        int sign=1, i=0;
        long ans=0;

        //Handle sign
        if(s.charAt(0)=='-'){
            i++; sign=-1;
        }
        else if(s.charAt(0)=='+'){
           i++; sign=1;
        }
        // only pick digits else come out of loop
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            ans= ans*10 + (s.charAt(i)-'0');

            //Max Min Handling
            if(sign== 1 &&  ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign==-1 && -ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }
        return (int)ans*sign;
    }
}

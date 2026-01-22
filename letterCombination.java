class Solution {
    public void helper(char[][] letter, String digits, List<String> ans, StringBuilder s, int i){
        if(i== digits.length()){
            ans.add(s.toString());
            return;
        }

        int digit= digits.charAt(i)-'0';
        char option[]= letter[digit];

        for(int j=0; j<option.length; j++){
            s.append(option[j]);
            helper(letter, digits, ans, s, i+1);
            s.deleteCharAt(s.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        
        if(digits==null || digits.length()==0) return new ArrayList<>();

        char[][] letters = {
            {},                 // 0
            {},                 // 1
            {'a','b','c'},      // 2
            {'d','e','f'},      // 3
            {'g','h','i'},      // 4
            {'j','k','l'},      // 5
            {'m','n','o'},      // 6
            {'p','q','r','s'},  // 7
            {'t','u','v'},      // 8
            {'w','x','y','z'}   // 9
        };
        List<String> result = new ArrayList<>();
        helper(letters, digits, result, new StringBuilder(), 0);
        return result;
    }
}

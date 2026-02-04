class Solution {
  // map each char of one string to another for both strings...then verify each char maps to same char on a differ traverse
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1= new HashMap<>();
        HashMap<Character, Character> map2= new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c1= s.charAt(i);
            char c2= t.charAt(i);

            map1.put(c1, c2);
            map2.put(c2, c1);
        }

        for(int i=0; i<s.length(); i++){
            char c1= s.charAt(i);
            char c2= t.charAt(i);

            if(map1.get(c1) != c2) return false;
            if(map2.get(c2) != c1) return false;

        }
        return true;
    }
}

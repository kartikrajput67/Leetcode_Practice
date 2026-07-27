class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        //check with t str
        for(int i=0; i<t.length(); i++){
            if(!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) == 0) return false;
            else {//freq decrease
                map.put(t.charAt(i), map.get(t.charAt(i))-1);
            }
        }
        return true;
    }
}
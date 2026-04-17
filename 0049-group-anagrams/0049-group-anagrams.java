class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //1st method
        //run two loop check every element with ith element if anagram, store both in set to check repetition and List also for answer.
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<n; i++){

            if(!set.contains(strs[i])){
                List<String> temp = new ArrayList<>();
                set.add(strs[i]);
                temp.add(strs[i]);

                for(int j=i+1; j<n; j++){
                    if(Anagram(strs[i],strs[j])){
                        set.add(strs[j]);
                        temp.add(strs[j]);
                    }
                }
                ans.add(temp);
            }
        }
        return ans;
    }
    private boolean Anagram(String a, String b){
        if(a.length() != b.length()) return false;
        int[] freq = new int [26];
        for(int i=0; i<a.length(); i++){
            freq[a.charAt(i)-'a']++;
        }
        for(int i=0; i<b.length(); i++){
            freq[b.charAt(i)-'a']--;
        }
        for(int i: freq){
            if(i != 0) return false;
        }
        return true;
    }
}
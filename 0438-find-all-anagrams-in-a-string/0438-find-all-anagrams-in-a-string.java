class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int[] pfreq = new int[26];
        for(int i=0; i<p.length(); i++){
            pfreq[p.charAt(i)-'a']++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(n-i < p.length()) break;//anagram not possible

            else{ //check anagram
                int[] sfreq = new int[26];
                for(int j=0; j<p.length(); j++){
                    sfreq[s.charAt(i+j)-'a']++;
                }

                boolean anagram = true;
                for(int j=0; j<26; j++){
                    if(sfreq[j] != pfreq[j]){//this index not conatin anagram
                        anagram = false;
                        break;
                    }
                }
                if(anagram) ans.add(i);
            }
        }
        return ans;
    }
}
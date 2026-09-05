class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = p.length();
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        if(m > n) return ans;
        int[] sfreq = new int[26];
        int[] pfreq = new int[26];

        for(int i=0; i<m; i++){
            pfreq[p.charAt(i)-'a']++;
            sfreq[s.charAt(i)-'a']++;
        }
        int left = 0, right = m-1; // two pointer to slide window
       
        if(Arrays.equals(sfreq,pfreq)) ans.add(left);

        for(right=m; right<n; right++){
            sfreq[s.charAt(left++)-'a']--;
            sfreq[s.charAt(right)-'a']++;
            if(Arrays.equals(sfreq,pfreq)) ans.add(left);
        }
        return ans;
    }
}
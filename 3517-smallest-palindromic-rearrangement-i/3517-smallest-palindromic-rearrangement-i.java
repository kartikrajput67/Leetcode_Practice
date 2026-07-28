class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            freq[c-'a']++; 
        }

        StringBuilder sb = new StringBuilder();
        int middle = -1;
        for(int i=0; i<26; i++){
            if(freq[i] % 2 != 0) middle = ('a'+i);
            int fre = freq[i] /2;
            while(fre-- > 0){
                sb.append((char)('a'+i));
            }
        }

        String firstHalf = sb.toString();
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();

        if (middle != -1) {
            sb.append((char)(middle));
        }
        
        sb.append(secondHalf);
        return sb.toString();
    }
}
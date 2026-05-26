class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freqSmall = new int[26];
        int[] freqCap = new int[26];

        int n = word.length();
        int count = 0;

        for(int i=0; i<n; i++){
            char ch = word.charAt(i);
            if(ch <= 'z' && ch >= 'a') freqSmall[ch-'a']++;
            else freqCap[ch-'A']++;
        }

        for(int i=0; i<26; i++){
            if(freqSmall[i] != 0 && freqCap[i] != 0) count++;
        }
        return count;
    }
}
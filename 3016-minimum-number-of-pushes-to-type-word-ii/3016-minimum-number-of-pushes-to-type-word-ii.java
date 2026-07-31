class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans =0;
        int[] arr = new int[26];
        for(int i=0; i<n; i++){
            arr[word.charAt(i)-'a']++;
        }
        Arrays.sort(arr);

        for(int i=25; i>=0 && arr[i]>0; i--){
            ans += arr[i] * ((25-i)/8 + 1);
        }
        return ans;
    }
}
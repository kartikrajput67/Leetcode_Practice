class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 1) return strs[0];

        int maxEle = Integer.MAX_VALUE;
        String temp = strs[0];
        for(int i=1; i<n; i++){
            String s = strs[i];

            int count = 0;
            for(int j=0; j<s.length() && j<temp.length(); j++){
                if(s.charAt(j) == temp.charAt(j)) count++;
                else{
                    if(count == 0) return "";
                    break;
                }
            }
            maxEle = Math.min(count,maxEle);
        }
        return temp.substring(0,maxEle);
    }
}
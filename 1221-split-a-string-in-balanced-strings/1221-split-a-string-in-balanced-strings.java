class Solution {
    public int balancedStringSplit(String s) {
        int partitions = 0;
        int n = s.length();
        int l=0, r=0;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == 'L') l++;
            if(ch == 'R') r++;
            if(l == r) {
                partitions++;
                l=0;r=0;
            }
        }
        return partitions;
    }
}
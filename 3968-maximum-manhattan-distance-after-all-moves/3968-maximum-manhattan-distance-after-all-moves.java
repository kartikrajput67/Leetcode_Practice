class Solution {
    public int maxDistance(String moves) {
        int u=0,l=0,r=0,d=0,no = 0;
        for(int i=0; i<moves.length(); i++){
            char ch = moves.charAt(i);
            if(ch == 'U') u++;
            else if(ch == 'D') d++;
            else if(ch == 'L') l++;
            else if(ch == 'R') r++;
            else no++;
        }
        return Math.abs(u-d)+Math.abs(l-r)+no;
    }
}
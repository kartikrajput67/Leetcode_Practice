class Solution {
    public int trap(int[] height) {
        if(height.length <= 2) return 0;
        int n = height.length;
        int ans = 0;
        int lmx = height[0];
        int rmx =  height[n-1];
        int si = 1;
        int ei = n-2;

        while(si <= ei){
            if(lmx < rmx){
                if(height[si] < lmx) ans += lmx - height[si++];
                else lmx = height[si++];
            }
            else{
                if(height[ei] < rmx) ans+= rmx-height[ei--];
                else rmx = height[ei--];
            }
        }
        return ans;
    }
}
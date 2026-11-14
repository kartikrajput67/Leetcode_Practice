class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum+=nums.get(j);
                int subArrSize = j-i+1;
                System.out.println("outer" + sum);
                if(subArrSize <= r && subArrSize>=l){
                    if(sum > 0) {
                        ans = Math.min(ans,sum);
                        System.out.println("inner" + sum);
                    }
                }
                else if(subArrSize > r) break;
            }
        }
        return (ans == Integer.MAX_VALUE)?-1: ans;
    }
}
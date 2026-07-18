class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcd(nums[0],nums[nums.length-1]);
    }
    private int gcd(int a, int b){
        while(a>0 && b>0){
            if(a>b) a=a%b;
            else b = b%a;
        }
        return Math.max(a,b);
    }
}
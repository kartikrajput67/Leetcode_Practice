class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        long[] prefixGCD = new long[n];
        int max = 0;
        for(int i=0;i <n; i++){
            max = Math.max(max,nums[i]);
            prefixGCD[i] = gcd(max,nums[i]);
        }
        long sum = 0;
        Arrays.sort(prefixGCD);

        
        for(int i=0; i<n/2; i++){
            long gcd = gcd(prefixGCD[i],prefixGCD[n-i-1]);
            System.out.print(gcd);
            sum += gcd;
        }
        return sum;
    }
    private long gcd(long a, long b){
        while(a > 0 && b>0 && a!=b){
            if(a>b) a %= b;
            else b %= a;
        }
        return Math.max(a,b);
    }
}
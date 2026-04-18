class Solution {
    public int mirrorDistance(int n) {
        int copy = n;
        int reverse = 0;
        while(n > 0){
            int rem = n%10;
            reverse = reverse*10 + rem;
            n /= 10;
        }
        return Math.abs(reverse - copy);
    }
}
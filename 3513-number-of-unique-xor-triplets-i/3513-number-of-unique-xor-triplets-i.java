class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> set  = new HashSet<>();
        int n = nums.length;
        if(n < 3) return n;
        int i=2;
        while(n >= Math.pow(2,i)) i++;
        return (int)Math.pow(2,i);
    }
}
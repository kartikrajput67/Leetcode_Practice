class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums)set.add(i);
        int c = 1;
        for(int i=k; i<=100; i=k*c){
            c++;
            if(!set.contains(i)) return i;
        }
        return k*c;//not reachable
    }
}
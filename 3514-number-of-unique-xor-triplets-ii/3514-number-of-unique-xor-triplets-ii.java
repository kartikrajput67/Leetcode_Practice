class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        //store pair xors
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int xor = nums[i] ^ nums[j];
                if(!set.contains(xor)) set.add(xor); //set can store at max, max in nums in binary, where all its bits can be 1.eg- if 9 is max in nums arr then 9=1001 then at max = 1111= 0 to 15(almost 2^4)
            }
        }

       // store triplet xors
        Set<Integer> ans = new HashSet<>();
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            int num = it.next();
            for(int i=0; i<n; i++){
                int xor = nums[i] ^ num;

                if(!ans.contains(xor)) ans.add(xor);
            }
        }
        return ans.size();
    }
}
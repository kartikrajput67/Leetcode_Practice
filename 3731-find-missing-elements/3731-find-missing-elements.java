class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        int max = 0;
         int min = 101;//Max_value
         HashSet<Integer> set = new HashSet<>();

         for(int i:nums){
            set.add(i);
            if(i < min) min = i;
             if(i > max) max = i;
         }

         ArrayList<Integer> ans = new ArrayList<>();
         for(int i=min; i<= max; i++){
            if(!set.contains(i)) ans.add(i);
         }
         return ans;
         

    }
}
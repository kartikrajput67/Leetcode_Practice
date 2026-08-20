class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int [] result = new int[n];//also work as 1st array
        int k = 0, i=0;
        result[k] = nums[i++];

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[i++]);

        for(  ; i<n; i++){
            if(result[k] > temp.get(temp.size()-1)){
                result[++k] = nums[i];
            }
            else temp.add(nums[i]);
        }

        for(int j=0; j<temp.size(); j++){
            result[++k] = temp.get(j);
        }
        return result;
    }
}
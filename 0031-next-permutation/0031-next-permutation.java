class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        //find pivot where array breaks (lexicographically greater)
        int pivot = -1;
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            } 
        }
        // edge case when already max no of array
        if(pivot == -1) {
            Arrays.sort(nums);
            return;
        }

        //swap with immediately greater than pivot
        for(int i=n-1; i>=0; i--){
            if(nums[i] > nums[pivot]){
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }

        //sort remaining ele after swapping
        Arrays.sort(nums,pivot+1,n);
    }
}
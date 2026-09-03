class Solution {
    public boolean uniformArray(int[] nums1) {
        
        int n = nums1.length;
        int even = 0;
        int odd = 0;
        for(int i=0; i<n; i++){
            if(nums1[i] %2 == 0) even++;
            else odd++;
        }

        //case 1 : if all elements are either odd or even
        if(even == 0 || odd == 0) return true;

        //case 2: if some elements are odd and some are even
        //then only we can store odd ele in nums2 because (even-odd = odd)
        //so there must be a smaller odd ele than an even kyoki us even ya sabhi even ke place pe hm koi(even-odd) odd +ve value store kr ske

        int smallestOdd = Integer.MAX_VALUE, smallestEven = Integer.MAX_VALUE;
        for(int i:nums1){
            if(i % 2 ==0){
                smallestEven = Math.min(smallestEven, i);
            }
            else smallestOdd = Math.min(smallestOdd, i);
        }
        return smallestOdd < smallestEven;
    }
}
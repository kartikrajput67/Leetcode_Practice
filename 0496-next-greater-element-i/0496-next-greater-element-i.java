class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] ans = new int[n];
        int idx = -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i: nums2){
            while(!st.isEmpty() && i > st.peek()){
                map.put(st.peek(),i);
                st.pop();
            }
            st.add(i);
        }
        while(!st.isEmpty()){
            map.put(st.peek(),-1);
            st.pop();
        }

        for(int i: nums1){
            ans[++idx] = map.get(i);
        }
        return ans;
    }
}
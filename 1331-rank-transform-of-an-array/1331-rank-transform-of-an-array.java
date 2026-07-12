class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) return new int[]{};

        //sort the array
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i:arr) ans.add(i);
        Collections.sort(ans);
        
        //map array with rank
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank = 1;
        map.put(ans.get(0),rank);
        for(int i=1; i<ans.size(); i++){
            if(!map.containsKey(ans.get(i))) map.put(ans.get(i),++rank);
        }

        //copy rank in array
        for(int i=0; i<arr.length; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
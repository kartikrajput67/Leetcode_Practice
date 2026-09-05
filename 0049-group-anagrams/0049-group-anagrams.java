class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String, List<String>> hm = new HashMap<>();

        for(String s : strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = new String(ca);
            if(!hm.containsKey(key))hm.put(key, new ArrayList<>());
            hm.get(key).add(s);
        }

        return new ArrayList<>(hm.values());
    }
}
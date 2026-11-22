class Solution {
    public boolean checkString(String s) {
        boolean b = false;
        for(char c: s.toCharArray()){
            if(c == 'b') b = true;
            if(b && c == 'a') return false;
        }
        return true;
    }
}
class Solution {
    public boolean checkValidString(String s) {
        int n= s.length();
        int open = 0, star = 0;
        //left to right
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c == '(') open++;
            else if(c == '*') star++;
            else{
                if(open > 0) open--;
                else if(star > 0) star--;
                else return false;
            }
        }

        //right to left
        int close = 0;
        star = 0;
        for(int i=n-1; i>=0; i--){
            char c = s.charAt(i);
            if(c == ')') close++;
            else if(c == '*') star++;
            else{
                if(close > 0) close--;
                else if(star > 0) star--;
                else return false;
            }
        }
        return true;
    }
}
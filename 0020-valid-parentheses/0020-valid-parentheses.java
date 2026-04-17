class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.add(s.charAt(i));
            }
            else{
                if(ch == ')'){
                    if(!st.isEmpty() && st.peek() == '(')    st.pop();
                    else return false;
                }
                if(ch == '}'){
                    if(!st.isEmpty() && st.peek() == '{')    st.pop();
                    else return false;
                }
                if(ch == ']'){
                    if(!st.isEmpty() && st.peek() == '[')    st.pop();
                    else return false;
                }
            }
        }
        if(st.isEmpty()) return true;
        else return false;
    }
}
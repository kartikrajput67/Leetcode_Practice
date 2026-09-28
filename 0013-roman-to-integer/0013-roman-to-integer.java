class Solution {
    public int romanToInt(String s) {
        //the last given 3 cases in description can't be ignored like 4,9,40,90,400,900
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char c  = s.charAt(i);
            if(c == 'M') ans += 1000;
            else if(c == 'D') ans += 500;
            else if(c == 'C'){//special case 3rd
                if(i == s.length()-1) ans+= 100; // C = 100
                else if(s.charAt(i+1) == 'D') {
                    ans+= 400;
                    i++;
                }
                else if(s.charAt(i+1) == 'M'){
                    ans += 900;
                    i++;
                }
                else ans += 100;
            }
            else if(c == 'L') ans += 50;
            else if(c == 'X'){//special case 2nd
                if(i == s.length()-1) ans+= 10; // X = 10
                else if(s.charAt(i+1) == 'L') {
                    ans+= 40;
                    i++;
                }
                else if(s.charAt(i+1) == 'C') {
                    ans += 90;
                    i++;
                }
                else ans += 10;
            }
            else if(c == 'V') ans+= 5;
            else if(c == 'I'){//special case 3rd
                if(i == s.length()-1) ans+= 1; // I = 1
                else if(s.charAt(i+1) == 'V') {
                    ans+= 4;
                    i++;
                }
                else if(s.charAt(i+1) == 'X'){
                    ans += 9;
                    i++;
                } 
                else ans += 1;
            }
        }
        return ans;
    }
}
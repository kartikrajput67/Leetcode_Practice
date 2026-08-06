class Solution {
    public int smallestNumber(int n, int t) {
        for(int j=n; j<=n+10; j++){
            int digitProd = 1;
            int i = j;

            while(i > 0){
                int rem = i%10;
                digitProd *= rem;
                i /= 10;
            }

            if(digitProd % t == 0) return j; 
        }
        return -1;
    }
}
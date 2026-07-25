class Solution {
    public int maxProduct(int n) {

        //store digit frequency in an array
        int freq[] = new int[10];
        while(n > 0){
            int rem = n%10;
            freq[rem]++;
            n /= 10;
        }

        //traverse array to find max product of two digits
        int prod = 1;
        int count = 2;
        for(int i=9; i>=0; i--){
            if(freq[i] > 0) {
                prod *= i;
                freq[i]--;
                count--;
                if(count == 0) return prod;
                if(freq[i] > 0) return prod *= i;
            }
        }
        return prod;
    }
}
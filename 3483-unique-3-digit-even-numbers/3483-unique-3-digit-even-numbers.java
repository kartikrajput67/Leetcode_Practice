class Solution {
    public int totalNumbers(int[] digits) {
        int c=0;
        for(int n=100; n<999; n+=2){

            int[] arr = new int[10];
            for(int i=0; i<digits.length; i++) arr[digits[i]]++;

            int temp = n;
            boolean found = true;
            while(temp > 0){
                int rem = temp%10;
                if(arr[rem] == 0){
                    found = false;
                    break;
                }
                arr[rem]--;
                temp /= 10;
            }
            if(found){
                            System.out.println(n);
                            c++;

            } 
        }
        return c;
    }
}
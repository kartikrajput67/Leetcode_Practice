class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five=0, tens = 0;

        for(int i=0; i<n; i++){
            if(bills[i] == 5) five++;

            else if(bills[i] == 10){
                if(five == 0) return false;
                five--;
                tens++;
            }
            else{
                if(tens >= 1 && five >=1) {
                    tens--;
                    five--;
                }
                else if(five >= 3) {
                    five -= 3;
                    // System.out.println(five);
                }
                else return false;
            }
        }
        return true;
    }
}
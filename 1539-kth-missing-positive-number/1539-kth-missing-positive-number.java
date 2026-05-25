class Solution {
    public int findKthPositive(int[] arr, int k) {
        int len = arr.length;
        int missCount = 0, i=0, num = 1;
        while(i < len){
            if(arr[i] == num){
                num++;i++;
            }
            else{
                missCount++;
                if(missCount == k) return num;
                num++;
            }
        }
        return (num+k-1)-missCount;
    }
}
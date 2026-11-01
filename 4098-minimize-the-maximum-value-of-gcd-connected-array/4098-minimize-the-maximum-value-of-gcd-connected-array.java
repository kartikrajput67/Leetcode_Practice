class Solution {
    public long minimumMaxValue(int n, int index, int value) {
        if(value == 1) return -1;
        long p=value;
        for(long i=2; i*i<=value; i++){
            if(value%i == 0) {
                p = i;
                break;
            }
        }

        //left check
        if(value-p-2L*index < 0) return -1;
        if(index == n-1) return value;
        //right check
        return value+p+2*(n-index-2);
    }
}
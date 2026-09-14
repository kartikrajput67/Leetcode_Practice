class Solution {
    public boolean isRectangleOverlap(int[] A, int[] B) {

        if(B[0] >= A[2] || A[0] >= B[2] || A[1] >= B[3] || B[1] >= A[3]) return false;

        else return true;
    }
}
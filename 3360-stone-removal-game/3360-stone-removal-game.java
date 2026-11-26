class Solution {
    public boolean canAliceWin(int n) {
        boolean aliceTurn = true;
        int removeStone = 10;
        while(n>=0){
            if(aliceTurn) {
                if(n>=removeStone) {
                    n-=removeStone;
                    removeStone--;
                    aliceTurn = !aliceTurn;
                }
                else{
                    return false;
                }
            }
            else{
                if(n>=removeStone) {
                    n-=removeStone;
                    removeStone--;
                    aliceTurn = !aliceTurn;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
}
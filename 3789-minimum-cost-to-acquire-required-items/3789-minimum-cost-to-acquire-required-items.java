class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        //case -1 if costBoth is greater than or equal to the sum of cost1 and cost 2 then no need to use costBoth bcz it costs more
        if(costBoth>=cost1+cost2) return (long)need1*cost1+(long)need2*cost2;

        //case -2 if costBoth is smaller than the sume of cost1 and cost2 then we use it till common and then again check for remaining
        long ans = 0;
        ans += (long)costBoth * Math.min(need1,need2);//common added
        if(need1 > need2){
            ans+= Math.min((long)costBoth*(need1-need2),(long)(need1-need2)*cost1);
        }
        else{
            ans+= Math.min((long)costBoth*(need2-need1),(long)(need2-need1)*cost2);
        }
        return ans;
    }
}
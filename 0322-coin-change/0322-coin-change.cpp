class Solution {
public:
    int solve(int index,int amount,vector<int>&coins,vector<vector<int>>&dp){
        //base csase
        if(amount==0) return 0;
        if(amount<0) return 100000;
        if(dp[index][amount]!=-1) return dp[index][amount];
        int ans=INT_MAX;
        for(int i=index;i<coins.size();i++){
               int res=1+solve(i,amount-coins[i],coins,dp);
               ans=min(ans,res);
        }
        return dp[index][amount]=ans;
    }
    int coinChange(vector<int>& coins, int amount) {
        int n=coins.size();
        vector<vector<int>>dp(n,vector<int>(amount+1,-1));
        int val= solve(0,amount,coins,dp);
        if(val>=100000) return -1;
        return val;
    }
};
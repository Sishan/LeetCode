/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return helper(coins, amount, new int[amount]);
    }
    
    public int helper(int[] coins, int remaining, int[] count){
        if (remaining < 0) {
            return -1;
        }
        if (remaining == 0) {
            return 0;
        }
        if (count[remaining - 1] != 0) {
            return count[remaining - 1]; // in this case, we already calculated needed value before;
        }
        
        int min = Integer.MAX_VALUE;
        for (int coin : coins){
            int res = helper(coins, remaining - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[remaining - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remaining - 1];
    }
}
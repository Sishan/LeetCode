/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
*/

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int b0 = -prices[0], b1 = -prices[0]; // b0 = buy[i], b1 = buy[i -1]
        int s0 = 0, s1 = 0, s2 = 0; // s0 = sell[i], s1 = sell[i - 1], s2 = sell[i - 2]

        for (int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]); // key idea here!
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }

        return s0;
    }
}

/*
Define Recursion

buy[i]: To make a decision whether to buy at i, we either take a rest, 
by just using the old decision at i - 1, or sell at/before i - 2, then buy at i, 
We cannot sell at i - 1, then buy at i, because of cooldown.
sell[i]: To make a decision whether to sell at i, we either take a rest, by 
just using the old decision at i - 1, or buy at/before i - 1, then sell at i.
So we get the following formula:

buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);   
sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
*/
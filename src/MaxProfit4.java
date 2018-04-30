import java.util.Arrays;

/*
188. Best Time to Buy and Sell Stock IV
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class MaxProfit4 {
    //Greedy Method;247->4ms;
    //通过大量的记录2*K和更新prices.length，来保证贪心策略；
    public int maxProfit(int k, int[] prices) {
        // Memory Limit Exceeded, due to k are incredible big;
        if(k==0||prices.length==0)return 0;
        //k=Math.min(k,prices.length);247ms;
        //normal greedy method;
        if(k>=prices.length/2){
            int profit=0;
            for(int i=1;i<prices.length;i++){
                if(prices[i]>prices[i-1])
                    profit+=prices[i]-prices[i-1];
            }
            return profit;
        }


        //I have to store the middle profits,
        //so the method can drop some of middle profits due to the limit of k;
        int cost[]= new int[k];
        int profit[]= new int[k];
        //for(int i=0;i<k;i++)
            //cost[i]=Integer.MAX_VALUE;
        Arrays.fill(cost,Integer.MAX_VALUE);
        for(int c:prices){
            //二维表:cost[k],profit[k]，列为交易次数；
            //根据每天的价格，逐次更新k个交易，替换掉profit较低的交易；
            //cost越低越好，profit越高越好。

            if(cost[0]>c)cost[0]=c;
            //如果成本更新，导致
            if(profit[0]<c-cost[0])profit[0]=c-cost[0];

            for(int i=1;i<k;i++){
                //如果当天的成本更低，更新此次交易的成本
                if(cost[i]>c-profit[i-1])cost[i]=c-profit[i-1];
                //如果当天可赚的利润更高，更新此次的利润
                if(profit[i]<c-cost[i])profit[i]=c-cost[i];
            }
        }
        return profit[k-1];
    }

}

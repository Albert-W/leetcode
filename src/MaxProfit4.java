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
        for(int i=0;i<k;i++)cost[i]=Integer.MAX_VALUE;

        for(int c:prices){
            if(cost[0]>c)cost[0]=c;
            if(profit[0]<c-cost[0])profit[0]=c-cost[0];

            for(int i=1;i<k;i++){
                if(cost[i]>c-profit[i-1])cost[i]=c-profit[i-1];
                if(profit[i]<c-cost[i])profit[i]=c-cost[i];
            }
        }
        return profit[k-1];
    }

    public int maxProfit3(int[] prices) {
        //根据每天的价格同时优化二次买卖操作。
        int firstCost=Integer.MAX_VALUE;
        int firstProfit=0;
        int secondCost=Integer.MAX_VALUE;
        int secondProfit=0;
        for(int c:prices){
            //第一次的成本越小越更新，收益越高越更新；
            if(firstCost>c)firstCost=c; //firstCost越小越好
            //下一句不会与上一句同时发生，如果同时发生profit=0;
            if(firstProfit<c-firstCost)firstProfit=c-firstCost;//firstProfit越大越好

            //第二次买的成本，在当前价上，减去firstProfit。
            //如果同一天更新第二轮，结果相当于没有更新；
            if(secondCost>c-firstProfit)secondCost=c-firstProfit;
            //下一句不会与上一句同时发生，如果同时发生profit=firstProfit;
            if(secondProfit<c-secondCost)secondProfit=c-secondCost;


        }
        return secondProfit;

    }
}

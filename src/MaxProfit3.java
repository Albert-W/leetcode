/*
123. Best Time to Buy and Sell Stock III
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class MaxProfit3 {
    //Greedy Method
    public int maxProfit(int[] prices) {
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


    //Dynamic Programming;0->68.56;
    public int maxProfit3(int[] prices) {
        //for循环三次，和一次for循环，工作量三倍是一样的。
        //找到所有第一次交易的收易表；
        if(prices.length==0)return 0;

        int sumprofit[]=new int[prices.length];
        if(prices.length==0)
            return 0;
        int min=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            } else {
                if(prices[i]-min>profit){
                    profit=prices[i]-min;
                }
            }
            sumprofit[i]=profit;

        }
        profit=0;
        int max=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            if(prices[i]>max){
                max=prices[i];
            }else {
                if(max-prices[i]>profit){
                    profit=max-prices[i];
                }
            }
            sumprofit[i]+=profit;
        }
        //选择最高收益
        profit=sumprofit[0];
        for(int i=1;i<prices.length;i++){
            if(sumprofit[i]>profit)
                profit=sumprofit[i];
        }
        return profit;



    }








    //Dynamically divide the Array into two parts ,get the most of profit;
    public int maxProfit2(int[] prices) {
        int profit=0;
        for(int d=0;d<=prices.length;d++){
            int profitl=0,profitr=0;
            profitl=maxProfit(prices,0,d);
            if(d+1<=prices.length)
                profitr=maxProfit(prices,d,prices.length);
            if(profitl+profitr>profit)profit=profitl+profitr;

        }
        return profit;


    }
    //from start to end-1; doesn't contain end;
    public int maxProfit(int[] prices,int s,int e) {
        if(s==e)
            return 0;
        int min=prices[s];
        int profit=0;
        for(int i=s+1;i<e;i++){
            if(prices[i]<min){
                min=prices[i];
            } else {
                if(prices[i]-min>profit){
                    profit=prices[i]-min;
                }
            }

        }
        return profit;
    }
}

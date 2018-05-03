/*
746. Min Cost Climbing Stairs
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
Note:
cost will have a length in the range [2, 1000].
Every cost[i] will be an integer in the range [0, 999].
 */
public class MinCostClimbingStairs {
    //iteration
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        if(n==0)
            return 0;
        if(n==1)
            return 0;
        if(n==2)
            return Math.min(cost[0],cost[1]);
        int a=cost[0];
        int b=cost[1];
        int c=0;
        for(int i=2;i<n;i++){
            //站在assist[i]上的最小代价
            c=Math.min(b,a)+cost[i];
            a=b;
            b=c;
        }

        return Math.min(a,b);

    }
    //由于存在两种状态（站上，跳过），决定创建辅助数组保存站上的状态，推演跳出的状态。
    public int minCostClimbingStairs2(int[] cost) {
        int n=cost.length;
        int[] assist=new int[n];
        if(n==0)
            return 0;
        if(n==1)
            return 0;
        if(n==2)
            return Math.min(cost[0],cost[1]);
        assist[0]=cost[0];
        assist[1]=cost[1];
        for(int i=2;i<n;i++){
            //站在assist[i]上的最小代价
            assist[i]=Math.min(assist[i-1],assist[i-2])+cost[i];
        }

        return Math.min(assist[n-2],assist[n-1]);

    }
}

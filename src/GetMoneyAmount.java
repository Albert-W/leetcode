/*
375. Guess Number Higher or Lower II
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.

Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
/*
例如【1，2，3，4】
minmax 方案是，先3，后1

需要动态规划：先中i, 判断1~i-1, i+1~n 的最大值；
g(1..n,i)=min(i+max(g(1..i-1),g(i+1..n));
*/

class getMoneyAmount
{
    public int getMoneyAmount(int n)
    {
        
        int count = 0;
        for(int i = 1; i <= n; i++)
        {
        	int left = 1, right = n;
        	int mid=0;
            int temp = 0;
            while(left <= right)
            {
                mid = left + (right - left) / 2;
                
                if(mid == i) {
                	//temp-=mid;
                	break;
                }
                temp += mid;
                if(mid > i) right = mid - 1;
                else 	left = mid + 1;
            }
            if(temp>count)
            	count=temp;
        }
        return count;
    }
}
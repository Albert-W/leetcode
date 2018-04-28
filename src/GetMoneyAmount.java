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
record(1..n,i)=min(i+max(record(1..i-1),record(i+1..n));
[1,2,3,4]   选3: [1,2] ,3,[4,4]
            选4: [1,3] ,4
[1,2]       选2 :[1,1] , 2
            先1: 1 , [2,2]

1、画边界
2、画步长
3、画在步长之内的边界。
4、画在步长之内的一般情形。
5、返回动态规划的结果。
*/

class getMoneyAmount
{
    //a failed solution, binary search is not the best minmax.
//    public int getMoneyAmount_f(int n)
//    {
//
//        int count = 0;
//        for(int i = 1; i <= n; i++)
//        {
//        	int left = 1, right = n;
//        	int mid=0;
//            int temp = 0;
//            while(left <= right)
//            {
//                mid = left + (right - left) / 2;
//
//                if(mid == i) {
//                	//temp-=mid;
//                	break;
//                }
//                temp += mid;
//                if(mid > i) right = mid - 1;
//                else 	left = mid + 1;
//            }
//            if(temp>count)
//            	count=temp;
//        }
//        return count;
//    }
    public int getMoneyAmount(int n){
        int[][] record = new int[n][n];
        //步长为0；
        for(int i=0;i<n;i++){
            record[i][i]=0;
        }
        //步长为i;
        for(int i=1;i<n;i++){
            //从第j个数开始取,到j+i的一段 中的minmax;

            for(int j=0;j+i<n;j++){
                //minmax 中的min
                //其中首位两端的情型，注意取值时+1（这是下标与取值的区别）
                int temp =Math.min( j+1 + record[j+1][j+i], j+i+1 + record[j][j+i-1]);
                //其中三段式的可能
                for(int k=j+1;k<j+i;k++){
                    int money = k+1 + Math.max(record[j][k-1],record[k+1][j+i]);
                    //举最小值
                    if(money<temp)temp=money;
                }
                record[j][j+i]=temp;
            }
        }
        return record[0][n-1];
    }

}
import java.util.ArrayList;
import java.util.List;

/*
52. N-Queens II
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Seen this question in a real interview before?

 */
//由28.9 --> 72.86;
public class TotalNQueens {
    //为了程序的重用，results保存了所有的结果；
    private void dfs(int n, int[] record,ArrayList<int[]> results){
        int rows = record.length;
        if(n==0){
            results.add(record);
            return;
        }

        for(int i=0;i<rows;i++){
            // n子放rows-n行；所以只检查列就可以了O(n);
            int row=rows-n;
            int col=i;
            if(isValid(record,row,col)){
                record[row]=col;//记录落子信息；
                dfs(n-1,record,results); //dfs没有把record 带入；
                record[row]=-1;
            }
        }
    }
    private boolean isValid(int[] record,int row,int col){
        for(int i=0;i<row;i++){
            //[i,record[i] 与[row,col] 进行比较
            //r<row
            if (record[i]==col||
                Math.abs(record[i]-col)==Math.abs(row-i)){  //此处一一定要有括号，否则一直false;
                return false;
            }
        }
        return true;
    }

    //****这类题目，最好不局限于题目给定的数据结构，而用二维字符组
    public int totalNQueens(int n) {
        int[] record=new int[n];
        ArrayList<int[]> results=new ArrayList<>();
        dfs(n,record,results);
        return results.size();
    }
}

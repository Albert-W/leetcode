import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/*
51. N-Queens
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class RolveNQueens {
    //***由于每次落子都需要验证，当前的验证方法是O(n2),可以减为O(n);前题是存储落子信息。
    //int[] record 是存储的信息，需要共享，就需要在每次dfs中添加。
    private void dfs(int n, int[] record,char[][] chess, List<List<String>> results){
        int rows = chess.length;
        if(n==0){
            List<String> finalchess = new ArrayList<>();
            for(int i=0;i<rows;i++){
                //finalchess.add(chess[i].toString());//用toString()复制的是乱码；
                finalchess.add(String.valueOf(chess[i]));
            }
            results.add(finalchess);
            return;
        }

        for(int i=0;i<rows;i++){
            // n子放rows-n行；所以只检查列就可以了O(n);
            int row=rows-n;
            int col=i;

            if(isvalid(chess,record,row,col)){
                chess[row][col]='Q';
                record[row]=col;//记录落子信息；
                dfs(n-1,record,chess,results); //dfs没有把record 带入；
                chess[row][col]='.';
                record[row]=-1;
            }
        }
    }
    private boolean isvalid(char[][] chess,int[] record,int row,int col){
            for(int i=0;i<row;i++){
                if (record[i]==col||Math.abs(record[i]-col)==Math.abs(row-i)){  //此处一一定要有括号，否则一直false;
                    return false;
                }
            }

        return true;
    }

    //****这类题目，最好不局限于题目给定的数据结构，而用二维字符组
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] chess = new char[n][n];
        //change;
        int[] record=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chess[i][j]='.';
            }
        }
        dfs(n,record,chess,results);
        return results;
    }

    private void dfs2(int n, char[][] chess, List<List<String>> results){
        int rows = chess.length;
        if(n==0){
            List<String> finalchess = new ArrayList<>();
            for(int i=0;i<rows;i++){
                //finalchess.add(chess[i].toString());//用toString()复制的是乱码；
                finalchess.add(String.valueOf(chess[i]));
            }
            results.add(finalchess);
            return;
        }
        for(int i=0;i<rows;i++){
            // n子放rows-n行；所以只检查列就可以了
            int row=rows-n;
            int col=i;

            if(canPut(chess,row,col)){
                chess[row][col]='Q';
                dfs2(n-1,chess,results);
                chess[row][col]='.';
            }
        }
    }
    private boolean canPut(char[][] chess,int row,int col){
        for(int i=0;i<chess.length;i++){
            for(int j=0;j<chess.length;j++){
                if(chess[i][j]=='Q' &&
                    (i==row||j==col||Math.abs(i-row)==Math.abs(j-col))){  //此处一一定要有括号，否则一直false;
                    return false;
                }
            }
        }
        return true;
    }

    //***数据结构不方便；
    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> results = new ArrayList<>();
        //定义棋盘
        List<String> chess = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder temp=new StringBuilder();
            for(int j=0;j<n;j++){
                temp.append('.');
            }
            chess.add(temp.toString());
        }

        //进行深度优先偏历
        dfs(n,chess,results);
        return results;
    }
    //n 表示剩于棋子，index表示落子之处；
    private void dfs(int n,List<String> chess,List<List<String>> results ){
        int rows = chess.size();
        //棋子放完，results记录当前棋盘
        if(n==0){
            //results.add(chess);//如果直接添加，只会共享同一区域，因此应该新建空间。
            List<String> finalchess = new ArrayList<>();
            for(int i=0;i<rows;i++){
                finalchess.add(chess.get(i));
            }
            results.add(finalchess);
            return;
        }

        //一行是一条String, 因为先确定行数。
        // n子放rows-n行；
        for(int i=0;i<rows;i++){
            int row=rows-n;
            int col=i;

            //如果不能下
            if(!canPut(chess,row,col)){
                continue;
            }
            //能下；
            StringBuilder sb = new StringBuilder(chess.get(row));
            sb.setCharAt(col,'Q');
            chess.set(row,sb.toString());

            //落下一子
            dfs(n-1,chess,results);

            //如果无子可落,回溯
            sb = new StringBuilder(chess.get(row));
            sb.setCharAt(col,'.');
            chess.set(row,sb.toString());

        }
        return;
    }

    private boolean canPut(List<String> chess,int row, int col){
        for(int i=0;i<chess.size();i++){
            for(int j=0;j<chess.size();j++){
                if(chess.get(i).charAt(j)=='Q' &&
                    (i== row || j==col ||
                    Math.abs(i-row)==Math.abs(j-col))){
                    return false;
                }

            }
        }
        return true;
    }

}
